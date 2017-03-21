package bsuir.by.labWord2.modules;

import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.modules.Ship.Ship;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Сергей on 18.03.2017.
 */
public class QueueShips {
    /**Collection ship(queue ship) */
    private PriorityBlockingQueue<Ship> ships = new PriorityBlockingQueue<Ship>();
    /**collection of backList */
    private HashSet<String> blackList ;


    public  QueueShips(  PriorityBlockingQueue<Ship> ships) {
        this.ships = ships;
        getBlackList();
    }

    /**
     * Get Black List from Data Base
     */
    public QueueShips() {
        getBlackList();
    }

    /**
     * Initialize black list with DataBase
     */
    private void getBlackList(){
        blackList = DataBaseDriver.getBlackListName();
    }

    /**
     * Get queue of ships
     * @return list of queue ships
     */
    public ArrayList<Ship> getShipList(){
        return new ArrayList<Ship>(ships);
    }

    /**
     * Get ship from queue
     * @return Object Shi[
     * @throws InterruptedException
     */
    public Ship getShip() throws InterruptedException {
        Ship ship = ships.take();
        return ship;
    }

    /**
     * Add ship in queue
     * @param ship Object Ship
     */
    public void addShip(Ship ship){
        if(blackList.contains(ship.getName())){
            ship.setPriority(13);
        }
        ships.put(ship);
    }

    /**
     * Add Ship in Black list
     * @param ship ship which added in black list
     */
    public void addBlackList(Ship ship){
        blackList.add(ship.getName());
        DataBaseDriver.addShipInBlackList(ship.getName());
    }
}
