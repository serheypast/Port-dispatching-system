package bsuir.by.labWord2.thread;

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
    private final static int POOL_SIZE = 3; // размер пула
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private volatile QueueShips queueShips;
    private volatile Stock stock;

    public PortPool() {

    }

    public PortPool(QueueShips queueShips, Stock stock) {
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            throw new ResourсeException(e);
        }
        throw new ResourсeException(":превышено время ожидания");
    }
    public void returnResource() {
        semaphore.release();
    }

    public void startPier(){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        for(int i  = 0; i < POOL_SIZE; i++){

            Pier pier = new Pier(this,stock);
            pier.setPierName("pier №" + Integer.toString(i + 1));
            service.scheduleAtFixedRate(pier,0,1,TimeUnit.SECONDS);
        }
        System.out.println(stock.getProducts());

    }
}
