package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.modules.Ship;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Pier extends Thread {
    private PortPool shipPortPool;
    private String name;
    private boolean free;
    private Ship ship;


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
        do {
            Ship ship = null;
            try {
                ship = shipPortPool.getResource(10000);
                System.out.println(ship + " In pier name: " + name);
                sleep(10000);
            } catch (ResourсeException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            shipPortPool.returnResource();
        }while(true);
    }
}
