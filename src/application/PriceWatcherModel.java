package application;

import java.util.Date;

public class PriceWatcherModel extends ScrapePrice{

    static Item [] items = new Item[10];

    public static float calculateChange(double price){
        double randPrice = Math.random();
        float percentage = (float) ((price*10)/ randPrice);
        //float percentage = (float) ((price)/ price) - 1;
        return percentage;
    }
    public double getPrice(String url){
        return ScrapePrice.priceScraper(url);
    }

    public static Item addItem(String name, double price, String url){
        Date date = new Date();
        items[0] = new Item(name, price, url);
//        PriceWatcherController.DisplayItem(items[0], calculateChange(price), date);
        System.out.println("Item :" + name  + " Has been added");
        return items[0];
    }
}
