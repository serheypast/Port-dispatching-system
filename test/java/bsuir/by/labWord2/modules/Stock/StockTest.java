package bsuir.by.labWord2.modules.Stock;

import bsuir.by.labWord2.modules.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 21.03.2017.
 */
public class StockTest {
    @Test
    public void putProductInStock() throws Exception {
        Stock stock = new Stock();
        int size = stock.getProducts().get(Product.MILK.getProduct());
        stock.putProductInStock(Product.MILK.getProduct(),10);
        Assert.assertEquals(String.valueOf(size + 10),stock.getProducts().get(Product.MILK.getProduct()).toString());
    }

}