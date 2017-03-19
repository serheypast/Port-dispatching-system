package bsuir.by.labWord2.run;

/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.gui.FormInitializer;
import bsuir.by.labWord2.gui.MainForm;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.thread.PortPool;
import bsuir.by.labWord2.thread.QueueShips;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;


public class Main {
   public static void main(String args[]) {
        try {

            QueueShips ships = new QueueShips();
            for(int i = 0; i< 10;i++){
                ships.addShip(InitializerShip.getRandomShip());
            }
            Stock stock = new  Stock();
            PortPool port = new PortPool(ships,stock);
            port.startPier();
            MainForm window = new MainForm(stock,ships);
            window.setBlockOnOpen(true);

            window.open();

            Display.getCurrent().dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
