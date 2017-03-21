package bsuir.by.labWord2.logger.portLogger;

import bsuir.by.labWord2.gui.portForm.MainForm;
import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.thread.PortPool;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * Created by Сергей on 20.03.2017.
 */
public class PortLogger extends Thread {
    /**
     * object for storing information
     * about products in ship
     */
    private Stock stock;
    /** object for storing queue ship */
    private QueueShips queueShips;
    /** object for get access gui*/
    private MainForm mainForm;

    /**
     * Constructor for initialize
     * @param stock   object for storing information about products in ship
     * @param queueShips  object for storing queue ship
     * @param mainForm object for get access gui
     */
    public PortLogger(Stock stock, QueueShips queueShips, MainForm mainForm) {
        this.stock = stock;
        this.queueShips = queueShips;
        this.mainForm = mainForm;
    }


    @Override
    public void run() {
        AppLogger.getLogger().info("Product in stock:\n)"  + stock.getProducts());
        AppLogger.getLogger().info("Ship in queue: \n" + queueShips.getShipList());
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= PortPool.POOL_SIZE; i++) {
                    String infAboutShip = "Ship in Pier № " + String.valueOf(i);
                    Table table = mainForm.getTablePier(i);
                    for (TableItem item: table.getItems()
                         ) {
                        infAboutShip += "\n"+item.getText();
                    }
                    System.out.println(infAboutShip);
                    AppLogger.getLogger().info(infAboutShip);
                }
            }
        });

    }


}
