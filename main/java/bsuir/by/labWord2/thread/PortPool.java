package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.gui.portForm.UpdateForm;
import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Сергей on 18.03.2017.
 */
public class PortPool{
    /** const size of Number of simultaneous threads */
    public final static int POOL_SIZE = 3; // размер пула
    /** semaphore for simultaneous access*/
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    /** object for storing queue ship */
    protected QueueShips queueShips;
    /**
     * object for storing information
     * about products in ship
     */
    private Stock stock;
    /** object for update gui(main form)*/
    protected  UpdateForm updateForm;

    /**
     * Constructor
     * @param queueShips - object for storiing ship
     * @param stock - object where store info about products
     * @param updateForm
     */
    public PortPool(QueueShips queueShips, Stock stock, UpdateForm updateForm) {
        this.queueShips = queueShips;
        this.stock = stock;
        this.updateForm = updateForm;
    }

    public PortPool() {

    }

    public PortPool(QueueShips queueShips, Stock stock) {
        this.queueShips = queueShips;
        this.stock = stock;
    }

    public PortPool(QueueShips queueShips) {
        this.queueShips = queueShips;
    }

    /**
     * The method retrieves the ship from the queue and sends it to the berth
     * @param maxWaitMillis - Time of duration
     * @return - shi[ from queue
     * @throws ResourсeException
     */
    public Ship getResource(long maxWaitMillis) throws ResourсeException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                Ship ship = queueShips.getShip();
                return ship;
            }
        } catch (InterruptedException e) {
            AppLogger.getLogger().error(e.getMessage());
            throw new ResourсeException(e);
        }

        throw new ResourсeException(":превышено время ожидания");
    }
    public void returnResource() {
        semaphore.release();
    }

    /**
     * The method where createt and run Pier
     */
    public void startPier(){

        for(int i  = 1; i <= POOL_SIZE; i++){
            Pier pier = new Pier(this,stock);
            pier.setPierName(i);
            pier.setName("Pier" + Integer.toString(i + 1));
            pier.start();
        }
        System.out.println(stock.getProducts());

    }
}
