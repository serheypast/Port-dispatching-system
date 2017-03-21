package bsuir.by.labWord2.modules.Ship;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Сергей on 17.03.2017.
 */
public class Ship implements Comparable<Ship>{
    private String name;
    private int time;
    private HashMap<String,Integer> products;
    private int priority;
    private boolean loadUnLoad;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getLoadUnLoad() {
        return loadUnLoad;
    }

    public void setLoadUnLoad(boolean loadUnLoad) {
        this.loadUnLoad = loadUnLoad;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public HashMap<String,Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String,Integer> products) {
        this.products = products;
    }


    public Ship(String name, int time, HashMap<String,Integer> products, int priority) {
        this.name = name;
        this.time = time;
        this.products = products;
        this.priority = priority;
    }

    public Ship() {

    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", products=" + products +
                ", priority=" + priority +
                "}\n";
    }

    public int compareTo(Ship o) {
        if(o.getPriority() <= priority){
            return 1;
        }
        else{
            return -1;
        }
    }
}
