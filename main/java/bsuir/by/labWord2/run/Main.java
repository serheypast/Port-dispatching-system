package bsuir.by.labWord2.run;

/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.gui.MainForm;
import bsuir.by.labWord2.gui.UpdateForm;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.thread.AutoShipbuilding;
import bsuir.by.labWord2.thread.PortPool;
import bsuir.by.labWord2.modules.QueueShips;

import static java.lang.Thread.sleep;


public class Main {
   public static void main(String args[]) {
        try {
            long startTimer = System.currentTimeMillis();

            sleep(1001);
            System.out.println(System.currentTimeMillis() - startTimer);
            DataBaseDriver.Conn();
            InitializerShip initializerShip = new InitializerShip();
            QueueShips ships = new QueueShips();
            for(int i = 0; i< 10;i++){
                ships.addShip(InitializerShip.getRandomShip());
            }
            Stock stock = new  Stock();

            MainForm window = new MainForm(stock,ships);
            UpdateForm updateForm = new UpdateForm(window,stock);
            PortPool port = new PortPool(ships,stock,updateForm);
            port.startPier();
            AutoShipbuilding autoShipbuilding = new AutoShipbuilding(updateForm,ships);
            autoShipbuilding.start();
            window.open();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
