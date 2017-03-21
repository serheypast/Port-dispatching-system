package bsuir.by.labWord2.run;

/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.gui.portForm.MainForm;
import bsuir.by.labWord2.gui.portForm.UpdateForm;
import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.logger.portLogger.PortLogger;
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
            DataBaseDriver.Conn();
            Stock stock = new  Stock();
            QueueShips ships = getRandomQueueShips();
            MainForm window = new MainForm(stock,ships);
            UpdateForm updateForm = new UpdateForm(window,stock);
            PortPool port = new PortPool(ships,stock,updateForm);
            port.startPier();
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleWithFixedDelay(new PortLogger(stock,ships,window), 0, 5, TimeUnit.SECONDS);
            service.scheduleWithFixedDelay(new AutoShipbuilding(updateForm,ships),10000,1000,TimeUnit.MILLISECONDS);
            window.open();

            
        } catch (Exception e) {
             AppLogger.getLogger().error(e.getMessage());
        }
    }


    private static QueueShips getRandomQueueShips(){
        QueueShips ships = new QueueShips();
        for(int i = 0; i< 10;i++) {
            ships.addShip(InitializerShip.getRandomShip());
        }
        return ships;
    }
}
