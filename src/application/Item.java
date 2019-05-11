package application;
/* Carlos Cabada * CS 3331 - Spring 2019
 * Programming Assignment 4: Item.java
 * Date: April 24, 2019
 * Instructor: Elsa Tai Ramirez * */
import javax.swing.text.Document;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Item {
    Random rand = new Random();
    String name = "Samsung - UE590 Series 28\" LED 4K UHD Monitor - Black";
    double price = rand.nextInt(50)+50;
    String url = "https://www.bestbuy.com/site/samsung-ue590-series-28-led-4k-uhd-monitor-black/5484022.p?skuId=5484022";
    float change  = (float) PriceWatcherModel.calculateChange(price);
    Date date;

    Item(String name, double price, String URL){
        this.name = name;
        this.price = price;
        this.url = URL;
    }

    Item(String name, double price, String URL, float change, Date date){
        this.name = name;
        this.price = price;
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
    public void setUrl(String URL){
        this.url = URL;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setChange(float change){

    }
    public String getName(){
        return name;
    }
    public double getPrice(){return price;}
    public String getUrl(){return url;}

    public Date getDate() {
        return date;
    }

    public float getChange() {
        return change;
    }
}
