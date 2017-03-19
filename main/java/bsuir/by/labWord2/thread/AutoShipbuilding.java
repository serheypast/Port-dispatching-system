package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.gui.UpdateForm;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Ship.Ship;

/**
 * Created by Сергей on 20.03.2017.
 */
public class AutoShipbuilding extends Thread {
    private UpdateForm updateForm;
    private QueueShips queueShips;
    public AutoShipbuilding() {
    }

    public AutoShipbuilding(UpdateForm updateForm, QueueShips queueShips) throws InterruptedException {
        sleep(10000);
        this.updateForm = updateForm;
        this.queueShips = queueShips;
    }

    @Override
    public void run() {
        do{
            Ship ship = InitializerShip.getRandomShip();
            queueShips.addShip(ship);
            updateForm.addShipInQueue(ship);
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(true);
    }
}
