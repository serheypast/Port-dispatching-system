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
    public final static int POOL_SIZE = 3; // размер пула
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    protected volatile QueueShips queueShips;
    private volatile Stock stock;
    protected volatile UpdateForm updateForm;


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

    public void startPier(){

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        for(int i  = 1; i <= POOL_SIZE; i++){
            Pier pier = new Pier(this,stock);
            pier.setPierName(i);
            pier.setName("Pier" + Integer.toString(i + 1));
            pier.start();
        }
        System.out.println(stock.getProducts());

    }
}
