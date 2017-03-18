package bsuir.by.labWord2.modules;

import java.util.LinkedList;

/**
 * Created by Сергей on 18.03.2017.
 */
public class Stock {
    private LinkedList<String> products = new LinkedList<String>();

    public Stock(LinkedList<String> products) {
        this.products = products;
    }

    public Stock() {
    }

    public LinkedList<String> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<String> products) {
        this.products = products;
    }




}
