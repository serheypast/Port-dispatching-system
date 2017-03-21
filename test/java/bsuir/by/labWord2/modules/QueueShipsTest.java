package bsuir.by.labWord2.modules;

import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.modules.Ship.Ship;
import org.junit.Assert;
import org.junit.Test;
import sun.java2d.pipe.AAShapePipe;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 21.03.2017.
 */
public class QueueShipsTest {
    @Test
    public void addShip() throws Exception {
        DataBaseDriver.Conn();
        QueueShips ships = new QueueShips();
       Ship ship = new Ship();
        ship.setName("Test");
        ships.addShip(ship);
        Assert.assertEquals(ship,ships.getShip());

        Ship testShip = new Ship();
        testShip.setName("asdasd");
        testShip.setPriority(1123);
        ships.addShip(testShip);
        Assert.assertEquals(ships.getShip(),testShip);
    }



}