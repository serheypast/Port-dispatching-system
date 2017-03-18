package bsuir.by.labWord2.modules.Stock;

import bsuir.by.labWord2.modules.Product;
import org.omg.CORBA.INTERNAL;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Сергей on 18.03.2017.
 */
public class InitializerStock {
    private final static int MIN_QUANTITY_PRODUCTS = 20;

    public static ConcurrentHashMap<String,Integer> getRandomProducts(){
        ConcurrentHashMap<String,Integer> products = new ConcurrentHashMap<>();
        for (Product product: Product.values()
             ) {
            products.put(product.getProduct(),((int)(Math.random()*10)) + MIN_QUANTITY_PRODUCTS);
        }
        return products;
    }
}
