package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;

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
                this.setName("Pier");
                System.out.println(this.getName() + "tut");
                ship = shipPortPool.getResource(10000);
                int sleepTime = ship.getProducts().size() * 700;
                System.out.println(ship + " In pier id: " + id);
                stock.putShipInStock(ship);
                shipPortPool.updateForm.addShipInPier(ship, id);
                shipPortPool.updateForm.addProductsInStock(ship, id);
                shipPortPool.updateForm.removeShipFromQueue(ship, id);
                sleep(sleepTime);
                shipPortPool.returnResource();

            }while (true);
            } catch(ResourсeException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
