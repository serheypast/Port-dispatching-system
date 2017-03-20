package bsuir.by.labWord2.logger;

import bsuir.by.labWord2.gui.MainForm;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.run.Main;
import bsuir.by.labWord2.thread.PortPool;
import javafx.scene.control.ListView;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Display;

/**
 * Created by Сергей on 20.03.2017.
 */
public class PortLogger extends Thread {
    private Stock stock;
    private QueueShips queueShips;
    private MainForm mainForm;


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
                    ListViewer listViewer = mainForm.getListViewer(i);
                    for (String line: listViewer.getList().getItems()
                         ) {
                        infAboutShip += "\n"+line;
                    }
                    AppLogger.getLogger().info(infAboutShip);
                }
            }
        });

    }


}
