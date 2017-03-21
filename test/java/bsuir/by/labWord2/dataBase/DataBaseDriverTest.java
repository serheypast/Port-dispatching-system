package bsuir.by.labWord2.dataBase;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 21.03.2017.
 */
public class DataBaseDriverTest {
    @Test
    public void conn() throws Exception {
        DataBaseDriver.Conn();
        Assert.assertNotNull(DataBaseDriver.conn);
        Assert.assertNotNull(DataBaseDriver.statmt);
    }

}