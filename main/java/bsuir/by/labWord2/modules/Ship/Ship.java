package bsuir.by.labWord2.modules.Ship;

import java.util.LinkedList;

/**
 * Created by Сергей on 17.03.2017.
 */
public class Ship implements Comparable<Ship>{
    private String name;
    private int time;
    private LinkedList<String> products;
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

    public LinkedList<String> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<String> products) {
        this.products = products;
    }


    public Ship(String name, int time, LinkedList<String> products, int priority) {
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
        if(o.getPriority() > priority){
            return 1;
        }
        else{
            return -1;
        }
    }
}
