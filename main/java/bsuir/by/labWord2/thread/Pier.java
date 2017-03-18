package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Pier extends Thread {
    private PortPool shipPortPool;
    private String name;
    private Stock stock;

    public Pier(PortPool shipPortPool, Stock stock) {
        this.shipPortPool = shipPortPool;
        this.stock = stock;
    }

    public String getPierName() {
        return name;
    }


    public void setPierName(String name) {
        this.name = name;
    }

    public Pier(PortPool shipPortPool) {
        this.shipPortPool = shipPortPool;
    }

    public Pier() {
    }

    @Override
    public void run() {
        Ship ship = null;
        try {
            ship = shipPortPool.getResource(10000);
            stock.putShipInStock(ship);
            System.out.println(ship + " In pier name: " + name);
        } catch (ResourсeException e) {
            e.printStackTrace();
        }
        shipPortPool.returnResource();
    }
}
