package bsuir.by.labWord2.modules.Ship;

import bsuir.by.labWord2.dataBase.DataBaseDriver;
import bsuir.by.labWord2.modules.Product;
import bsuir.by.labWord2.modules.Ship.Ship;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Сергей on 18.03.2017.
 */
public class InitializerShip {
    private final static int DEFAULT_TIME = 10000;
    private final static int DEFAULT_PRIORITY = 5;
    private static LinkedList<String> names = DataBaseDriver.getListName();
    public InitializerShip() {

    }

    public static Ship getRandomShip(){
        Ship ship = new Ship();
        ship.setName(randomName());
        ship.setTime(DEFAULT_TIME);
        ship.setPriority(DEFAULT_PRIORITY + (int)(Math.random()*10));
        ship.setProducts(randomProducts());
        return ship;
    }

    private static String randomName(){
        String firstName = names.get((int)(Math.random()*100) % names.size());
        String lastName = names.get((int)(Math.random()*100) % names.size());
        return firstName + " " + lastName;
    }

    private static HashMap<String,Integer> randomProducts(){
        HashMap<String,Integer> linkedList = new HashMap<String,Integer>();
        int sizeOfList = (int)(Math.random()*20) + 1;
        for(int i = 0 ; i < sizeOfList; i++){
            int current = ((int)(Math.random()*10)) % Product.values().length;
            String product = Product.values()[current].getProduct();
            if(!linkedList.containsKey(product)){
                linkedList.put(product,1);
            }else{
                int size = linkedList.get(product);
                linkedList.put(product,++size);
            }
        }
        return linkedList;
    }
}
