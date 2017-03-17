package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.modules.Ship;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Pier extends Thread {
    private PortPool shipPortPool;

    private boolean free;
    private Ship ship;

    public Pier(PortPool shipPortPool) {
        this.shipPortPool = shipPortPool;
    }

    public Pier() {
    }

    @Override
    public void run() {
        do {
            Ship ship = null;
            try {
                ship = shipPortPool.getResource(10000);

            } catch (ResourсeException e) {
                e.printStackTrace();
            }


            System.out.println(ship.getName());
            shipPortPool.returnResource();
        }while(true);
    }
}
