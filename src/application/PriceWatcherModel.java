package application;

import org.json.JSONException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    private DefaultListModel defaultListModel;
    private Storage Storage;
    public static boolean isFilter = false;

    /**
     * Default Constructor.
     *
    */
    public static class Sorting {
        static DefaultListModel defaultListModel;
        static Storage Storage;

        public Sorting(Storage Storage, DefaultListModel defaultListModel) {
            Sorting.defaultListModel = defaultListModel;
            Sorting.Storage = Storage;
        }

        /**
         * Sorts the object from oldest date.
         */
        public static void sortOld() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> item2.getDate().compareTo(item1.getDate()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }

        /**
         * Sorts the JList and object from newest date.
         */
        public static void sortNew() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> item1.getDate().compareTo(item2.getDate()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }

        /**
         * Sorts the items into ascending
         * order.
         */
        public static void sortNameAscending() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> item2.getName().compareTo(item1.getName()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }

        /**
         * Sorts the items into Descending
         * order.
         */
        public static void sortNameDescending() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> item1.getName().compareTo(item2.getName()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }

        /**
         * Sorts items from highest price to lowest.
         */
        public static void sortHigh() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> Double.valueOf("" + item1.getCurrentPrice()).compareTo(item2.getCurrentPrice()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }


        public static void sortLow() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> Double.valueOf("" + item2.getCurrentPrice()).compareTo(item1.getCurrentPrice()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }

        public static void sortChangeHigh() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> Double.valueOf("" + item2.getChange()).compareTo(item1.getChange()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }


        public void sortChangeLow() {
            java.util.List<Item> items = Storage.getItems();
            Collections.sort(items, (Item item2, Item item1) -> Double.valueOf("" + item1.getChange()).compareTo(item2.getChange()));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
        }


        public void filterBy(String filter) throws JSONException{
            if (isFilter) {
                removeFilter();
            }
            java.util.List<Item> items = Storage.getItems();
            items.removeIf(s -> !s.getURL().contains(filter));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
            isFilter = true;
        }


        public void filterName(String filter) throws JSONException{
            if (isFilter) {
                removeFilter();
            }
            List<Item> items = Storage.getItems();
            items.removeIf(s -> !s.getName().contains(filter));
            Storage.set(items);
            defaultListModel.removeAllElements();
            Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
            isFilter = true;
        }


        public void removeFilter() throws JSONException {
            if (isFilter) {
                try {
                    Storage.removeItem();
                    Storage.fromJSON();
                    Storage.getItems().forEach((element) -> defaultListModel.addElement(element));
                    isFilter = false;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
