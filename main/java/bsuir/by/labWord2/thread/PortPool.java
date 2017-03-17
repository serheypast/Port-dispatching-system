package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.modules.Ship;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Сергей on 18.03.2017.
 */
public class PortPool{
    private final static int POOL_SIZE = 3; // размер пула
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private QueueShips queueShips;
    public PortPool() {

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
}
