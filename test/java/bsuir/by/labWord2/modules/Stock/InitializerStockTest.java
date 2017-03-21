package bsuir.by.labWord2.modules.Stock;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 21.03.2017.
 */
public class InitializerStockTest {
    @Test
    public void getRandomProducts() throws Exception {
        ConcurrentHashMap<String,Integer> products = InitializerStock.getRandomProducts();
        Assert.assertNotNull(products);
        Assert.assertNotEquals(0,products.size());
    }

}