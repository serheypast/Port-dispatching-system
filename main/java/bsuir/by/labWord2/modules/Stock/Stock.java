package bsuir.by.labWord2.modules.Stock;

import bsuir.by.labWord2.logger.AppLogger;
import bsuir.by.labWord2.logger.PortLogger;
import bsuir.by.labWord2.modules.Ship.Ship;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Stock {
    private ConcurrentHashMap<String,Integer> products;

    public Stock( ConcurrentHashMap<String,Integer> products) {
        this.products = products;
    }

    public Stock() {
        products = InitializerStock.getRandomProducts();
    }

    public void putProductInStock(String product,int size){

        int quantityOfProduct = products.get(product) + size;
        products.put(product,quantityOfProduct);
    }

    public void removeProductInStock(String product,int size,String name){
        int quantityOfProduct = products.get(product) - size;
        if(quantityOfProduct > 0){
            products.put(product,quantityOfProduct);
        }
        else{
            AppLogger.getLogger().info("Ship name:" +name + "Can not take the product from stock");
        }

    }


    public void putShipInStock(Ship ship){
        if(ship.getLoadUnLoad()) {
            for (String product : ship.getProducts().keySet()
                    ) {
                putProductInStock(product, ship.getProducts().get(product));
            }
        }else
        {
            for (String product : ship.getProducts().keySet()
                    ) {
                removeProductInStock(product, ship.getProducts().get(product),ship.getName());
            }
        }
    }
    public ConcurrentHashMap<String,Integer> getProducts() {
        return products;
    }

    public void setProducts( ConcurrentHashMap products) {
        this.products = products;
    }




}
