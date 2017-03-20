package bsuir.by.labWord2.run;

/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.gui.portForm.MainForm;
import bsuir.by.labWord2.gui.portForm.UpdateForm;
import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.logger.PortLogger;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.thread.AutoShipbuilding;
import bsuir.by.labWord2.thread.PortPool;
import bsuir.by.labWord2.modules.QueueShips;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class Main {
   public static void main(String args[]) {
        try {
            long startTimer = System.currentTimeMillis();
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
            AppLogger.getLogger().info(ships.getShipList());
            port.startPier();
            AutoShipbuilding autoShipbuilding = new AutoShipbuilding(updateForm,ships);
            autoShipbuilding.start();
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleWithFixedDelay(new PortLogger(stock,ships,window), 0, 5, TimeUnit.SECONDS);

            window.open();

        } catch (Exception e) {
             AppLogger.getLogger().error(e.getMessage());
        }
    }


}
