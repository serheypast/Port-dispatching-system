package bsuir.by.labWord2.dataBase;
import java.sql.*;




public class DataBaseDriver {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;


    /**
     *  The method that create connection with DataBase
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:catalog.sqlite");
        statmt = conn.createStatement();
        System.out.println(conn.isClosed()  );
        System.out.println("Connected!");
    }



}
