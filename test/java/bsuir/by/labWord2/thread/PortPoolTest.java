package bsuir.by.labWord2.thread;

import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 21.03.2017.
 */
public class PortPoolTest {
    @Test
    public void getResource() throws Exception {
        DataBaseDriver.Conn();
        QueueShips ships = new QueueShips();
        Stock stock = new Stock();
        PortPool portPool = new PortPool(ships,stock);
        Ship ship = new Ship();
        ship.setName("test");

        ships.addShip(ship);
        Assert.assertEquals(ship,portPool.getResource(10000));
    }

}