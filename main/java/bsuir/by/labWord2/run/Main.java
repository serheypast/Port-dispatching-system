package bsuir.by.labWord2.run;



/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.gui.MainForm;

import bsuir.by.labWord2.modules.InitializerShip;
import bsuir.by.labWord2.thread.PortPool;
import bsuir.by.labWord2.thread.QueueShips;
import org.eclipse.swt.widgets.Display;

import java.util.UUID;


public class Main {
    public static void main(String args[]) {
        try {

            QueueShips ships = new QueueShips();
            for(int i = 0; i< 10;i++){
                ships.addShip(InitializerShip.getRandomShip());
            }
            PortPool port = new PortPool(ships);
            port.startPier();
            MainForm window = new MainForm();
            window.setBlockOnOpen(true);
            window.open();
            Display.getCurrent().dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


