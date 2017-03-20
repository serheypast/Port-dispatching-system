package bsuir.by.labWord2.dataBase;
import bsuir.by.labWord2.logger.AppLogger;

import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;


public class DataBaseDriver {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;


    /**
     *  The method that create connection with DataBase
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void Conn()
    {
        conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:D:\\dataBase\\PortBase.sqlite");
            statmt = conn.createStatement();
            System.out.println(conn.isClosed()  );
            System.out.println("Connected!");
        } catch (ClassNotFoundException e) {
            AppLogger.getLogger().error(e.getMessage());
        }catch (SQLException e) {
            AppLogger.getLogger().error(e.getMessage());
        }
    }

    public static LinkedList<String> getListName(){
        LinkedList<String> names = new LinkedList<>();
        try {
            DataBaseDriver.resSet = DataBaseDriver.statmt.executeQuery("SELECT * FROM Name");
            while(DataBaseDriver.resSet.next()){
                names.add(DataBaseDriver.resSet.getString(1));
                names.add(DataBaseDriver.resSet.getString(2));
            }
            return names;
        } catch (SQLException e) {
            AppLogger.getLogger().error(e.getMessage());
            return names;
        }
    }

    public static void addShipInBlackList(String name){
        try {
            DataBaseDriver.statmt.execute("INSERT INTO 'BlackList' ('Name')" +
                    " VALUES ('"+name+"'); ");
        } catch (SQLException e) {
            AppLogger.getLogger().error(e.getMessage());
        }
    }

    public static HashSet<String> getBlackListName(){
        HashSet<String> blackList = new HashSet<String>();
        try {
            DataBaseDriver.resSet = DataBaseDriver.statmt.executeQuery("SELECT * FROM BlackList");
            while(DataBaseDriver.resSet.next()){
                blackList.add(DataBaseDriver.resSet.getString(1));
            }
            return blackList;
        } catch (SQLException e) {
            AppLogger.getLogger().error(e.getMessage());
            return blackList;
        }
    }



}
