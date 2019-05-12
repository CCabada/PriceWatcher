package application;
/* Carlos Cabada * CS 3331 - Spring 2019
 * Programming Assignment 4: Item.java
 * Date: April 24, 2019
 * Instructor: Elsa Tai Ramirez * */
import java.util.Random;

public class Item {
    Random rand = new Random();
    String name;
    double price;
    double initialPrice;
    String url;
    float change;
    String date;

    Item(String name, double price, String URL){
        this.name = name;
        this.price = price;
        this.url = URL;
    }

    Item(String name, double price, double initialPrice, String URL, float change, String date){
        this.name = name;
        this.price = price;
        this.initialPrice = initialPrice;
        this.url = URL;
        this.change = change;
        this.date = date;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setInitialPrice(double price){
        this.initialPrice = price;
    }
    public void setUrl(String URL){
        this.url = URL;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setChange(float change){

    }
    public String getName(){
        return name;
    }
    public double getPrice(){return price;}
    public double getInitialPrice(){return initialPrice;}
    public String getUrl(){return url;}
    public String getDate() {
        return date;
    }
    public float getChange() {
        return change;
    }
}
