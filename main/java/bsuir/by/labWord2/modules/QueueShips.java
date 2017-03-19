package bsuir.by.labWord2.modules;

import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.gui.UpdateForm;
import bsuir.by.labWord2.modules.Ship.Ship;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Сергей on 18.03.2017.
 */
public class QueueShips {
    private PriorityBlockingQueue<Ship> ships = new PriorityBlockingQueue<Ship>();
    private HashSet<String> blackList ;
    public  QueueShips(  PriorityBlockingQueue<Ship> ships) {
        this.ships = ships;
        getBlackList();
    }

    public QueueShips() {
        getBlackList();
    }

    private void getBlackList(){
        blackList = DataBaseDriver.getBlackListName();
    }

    public ArrayList<Ship> getShipList(){
        return new ArrayList<Ship>(ships);
    }

    public Ship getShip() throws InterruptedException {
        Ship ship = ships.take();
        return ship;
    }

    public void addShip(Ship ship){

        ships.put(ship);
    }

    public void addBlackList(Ship ship){
        blackList.add(ship.getName());
        DataBaseDriver.addShipInBlackList(ship.getName());
    }
}
