package application;

import java.util.Date;

public class PriceWatcherModel extends ScrapePrice{

    static Item [] items = new Item[10];

    /**
     * Uses random values to return a price change.
     * @param price
     * @return price change
     */
    public static float calculateChange(double price){
        double randPrice = Math.random();
        float percentage = (float) ((price*10)/ randPrice);
        //float percentage = (float) ((price)/ price) - 1;
        return percentage;
    }

    /**
     * Calls web scraper to return price
     * @param url
     * @return price
     */
    public double getPrice(String url){
        return ScrapePrice.priceScraper(url);
    }

    public static Item addItem(String name, double price, String url){
        Date date = new Date();
        items[0] = new Item(name, price, url);
        System.out.println("Item :" + name  + " Has been added");
        return items[0];
    }
}
