package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;

import java.util.Timer;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Pier extends Thread {
    private PortPool shipPortPool;
    private int id;
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

    @Override
    public void run() {
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       Ship ship = null;
        try {
            do {
                ship = shipPortPool.getResource(10000);
                int sleepTime = ship.getProducts().size() * 700;
                long startTimer = System.currentTimeMillis();
                stock.putShipInStock(ship);
                shipPortPool.updateForm.addShipInPier(ship, id);
                shipPortPool.updateForm.addProductsInStock(ship, id);
                shipPortPool.updateForm.removeShipFromQueue(ship, id);
                long endTimer = System.currentTimeMillis();
                System.out.println(endTimer - startTimer);
                if(endTimer - startTimer > ship.getTime()){
                    shipPortPool.queueShips.addBlackList(ship);
                    System.out.println(ship.getName() + "this ship added in BlackList");
                }
                sleep(sleepTime);
                shipPortPool.updateForm.removeListAndBar(id);
                shipPortPool.returnResource();

            }while (true);
            } catch(ResourсeException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
