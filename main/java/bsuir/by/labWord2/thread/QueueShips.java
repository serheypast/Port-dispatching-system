package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.modules.Ship;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Сергей on 18.03.2017.
 */
public class QueueShips {
   // private List<Ship> ships;
    PriorityBlockingQueue<Ship> ships;
    public QueueShips(  PriorityBlockingQueue<Ship> ships) {
        this.ships = ships;
    }

    public QueueShips() {
        PriorityBlockingQueue<Ship> ships = new PriorityBlockingQueue<Ship>();
    }

    private ArrayList<Ship> getShipList(){
        return new ArrayList<Ship>(ships);
    }

    public Ship getShip() throws InterruptedException {
        Ship ship = ships.take();
        return ship;
    }

    public void addShip(Ship ship){
       ships.put(ship);
    }
}
