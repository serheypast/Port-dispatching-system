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
    /**Const parametr time for initialize */
    private final static int DEFAULT_TIME = 2000;
    /**Const  parametr for priority initialization*/
    private final static int DEFAULT_PRIORITY = 5;
    /**Collection for generate some name*/
    private static LinkedList<String> names = DataBaseDriver.getListName();
    public InitializerShip() {

    }

    /**
     * generate random ship
     * @return Random ship
     */
    public static Ship getRandomShip(){
        Ship ship = new Ship();
        ship.setName(randomName());
        ship.setTime(DEFAULT_TIME);
        ship.setPriority(DEFAULT_PRIORITY + (int)(Math.random()*10));
        ship.setProducts(randomProducts());
        ship.setLoadUnLoad(getRandomType());
        if(ship.getLoadUnLoad()){
            ship.setType("Loader");
        }else{
            ship.setType("Unloader");
        }
        return ship;
    }

    /**
     * Genetare random name for ship
     * @return Stirng nameOFShip
     */
    private static String randomName(){
        String firstName = names.get((int)(Math.random()*100) % names.size());
        String lastName = names.get((int)(Math.random()*100) % names.size());
        return firstName + " " + lastName;
    }

    /**
     * Generate random products
     * @return collection of products
     */
    public static HashMap<String,Integer> randomProducts(){
        HashMap<String,Integer> linkedList = new HashMap<String,Integer>();
        int sizeOfList = (int)(Math.random()*20) + 1;
        for(int i = 0 ; i < sizeOfList; i++){
            int current = ((int)(Math.random()*10)) % Product.values().length;
            String product = Product.values()[current].getProduct();
            if(!linkedList.containsKey(product)){
                linkedList.put(product,1);
            } else {
                int size = linkedList.get(product);
                linkedList.put(product,++size);
            }
        }
        return linkedList;
    }

    /**
     * Generate random Type of ship
     * @return Type of ship
     */
    private static boolean getRandomType(){
        if((int)(Math.random()*10)%2 == 1){
            return true;
        }else{
            return false;
        }
    }
}
