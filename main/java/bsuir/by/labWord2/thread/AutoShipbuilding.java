package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.gui.portForm.UpdateForm;
import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Ship.Ship;

/**
 * Created by Сергей on 20.03.2017.
 */
public class AutoShipbuilding extends Thread {
    /** object for connect gui and Auto ship adding*/
    private UpdateForm updateForm;

    /** object for storing queue ship */
    private QueueShips queueShips;
    public AutoShipbuilding() {
    }

    /**
     * Constructor for initialization
     * @param updateForm - object for connect gui and Auto ship adding
     * @param queueShips - object for storing queue ship
     * @throws InterruptedException
     */
    public AutoShipbuilding(UpdateForm updateForm, QueueShips queueShips) throws InterruptedException {

        this.updateForm = updateForm;
        this.queueShips = queueShips;
    }

    /**
     * The thread where generate different ship adn put them in queue
     */
    @Override
    public void run() {
        Ship ship = InitializerShip.getRandomShip();
        queueShips.addShip(ship);
        updateForm.addShipInQueue(ship);
    }
}
