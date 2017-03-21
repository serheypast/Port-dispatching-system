package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Pier extends Thread {
    /** Object class port, to access the queue and the warehouse*/
    private PortPool shipPortPool;
    /** id of Pier*/
    private int id;
    /**
     * object for storing information
     * about products in ship
     */
    private Stock stock;

    public Pier(PortPool shipPortPool, Stock stock) {
        this.shipPortPool = shipPortPool;
        this.stock = stock;
    }

    public int getPierName() {
        return id;
    }

    public void setPierName(int name) {
        this.id = name;
    }

    public Pier(PortPool shipPortPool) {
        this.shipPortPool = shipPortPool;
    }

    public Pier() {
    }

    /**
     * The thread that receives the ship from the queue, works with them, removes it
     */
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            AppLogger.getLogger().error(e.getMessage());
        }
       Ship ship = null;
        try {
            do {
                ship = shipPortPool.getResource(10000);
                int sleepTime = ship.getProducts().size() * 400;
                long startTimer = System.currentTimeMillis();
                stock.putShipInStock(ship);
                shipPortPool.updateForm.addShipInPier(ship, id);
                shipPortPool.updateForm.addProductsInStock(ship, id);
                shipPortPool.updateForm.removeShipFromQueue(ship, id);
                long endTimer = System.currentTimeMillis();
                System.out.println(endTimer - startTimer);
                if(endTimer - startTimer > ship.getTime()) {
                    shipPortPool.queueShips.addBlackList(ship);
                    AppLogger.getLogger().info(ship.getName() + "this ship added in BlackList");
                }
                Thread.sleep(sleepTime);
                shipPortPool.updateForm.removeTablePierAndBar(id);
                shipPortPool.returnResource();

            }while (true);
            } catch(ResourсeException e){
                AppLogger.getLogger().error(e.getMessage());
            } catch (InterruptedException e) {
                 AppLogger.getLogger().error(e.getMessage());
        }


    }
}
