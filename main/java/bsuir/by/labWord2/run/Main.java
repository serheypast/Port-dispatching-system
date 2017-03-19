package bsuir.by.labWord2.run;

/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.gui.FormInitializer;
import bsuir.by.labWord2.gui.MainForm;
import bsuir.by.labWord2.gui.UpdateForm;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.thread.PortPool;
import bsuir.by.labWord2.thread.QueueShips;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class Main {
   public static void main(String args[]) {
        try {


            QueueShips ships = new QueueShips();
            for(int i = 0; i< 10;i++){
                ships.addShip(InitializerShip.getRandomShip());
            }
            Stock stock = new  Stock();

            MainForm window = new MainForm(stock,ships);
            UpdateForm updateForm = new UpdateForm(window,stock);
            PortPool port = new PortPool(ships,stock,updateForm);
            port.startPier();
            window.open();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
