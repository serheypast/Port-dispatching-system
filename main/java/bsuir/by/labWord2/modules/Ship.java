package bsuir.by.labWord2.modules;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Сергей on 17.03.2017.
 */
public class Ship implements Comparable<Ship>{
    private String name;
    private int time;
    private ArrayList<String> products;
    private int priority;

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

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }


    public Ship(String name, int time, ArrayList<String> products, int priority) {
        this.name = name;
        this.time = time;
        this.products = products;
        this.priority = priority;
    }

    public Ship() {

    }


    public int compareTo(Ship o) {
        if(o.getPriority() > priority){
            return 1;
        }
        else{
            return -1;
        }
    }
}
