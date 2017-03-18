package bsuir.by.labWord2.modules.Ship;

import bsuir.by.labWord2.modules.Product;
import bsuir.by.labWord2.modules.Ship.Ship;

import java.util.LinkedList;

/**
 * Created by Сергей on 18.03.2017.
 */
public class InitializerShip {
    private final static int DEFAULT_TIME = 10000;
    private final static int DEFAULT_PRIORITY = 5;

    public InitializerShip() {

    }

    public static Ship getRandomShip(){
        Ship ship = new Ship();
        ship.setName(randomName());
        ship.setTime(DEFAULT_TIME);
        ship.setPriority(DEFAULT_PRIORITY);
        ship.setProducts(randomProducts());
        return ship;
    }

    private static String randomName(){
        String symbols = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder randString = new StringBuilder();
        int count = (int)(Math.random()*10) +  4;
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return new String(randString);
    }

    private static LinkedList<String> randomProducts(){
        LinkedList<String> linkedList = new LinkedList<String>();
        int sizeOfList = (int)(Math.random()*20) + 1;
        for(int i = 0 ; i < sizeOfList; i++){
            int current = ((int)(Math.random()*10)) % Product.values().length;
            String product = Product.values()[current].getProduct();
            linkedList.add(product);
        }
        return linkedList;
    }
}
