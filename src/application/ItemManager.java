package application;

import java.util.ArrayList;
import java.util.List;

/**
 * Item Class
 * Attributes
 */
public class ItemManager {
    
    private List<Item> listItems;

    /**
     * Constructor for the Item Manager
      */
    
    public ItemManager(){
        this.listItems = new ArrayList<>();
    }

    /**
     * Adds item to the ArrayList
     * @param item
     */
    public void addItem(Item item){
        this.getItems().add(item);
    }

    /**
     * Deletes item from ArrayList
     * @param item
     */
    public void deleteItem(int item){
        this.getItems().remove(item);
    }

    /**
     * Removes all the items from the ArrayList.
     */
    public void removeItem(){
        this.listItems = new ArrayList<>();
    }
    /**
     * Gets the items from the
     */
    public List<Item> getItems() {
        return this.listItems;
    }

    /**
     * Checks if the array is empty
     * @return
     */
    public void set(List<Item> arrOfProducts) {
        this.listItems = arrOfProducts;
    }


    public boolean  isEmpty(){
        return getItems()== null;
    }

    /**
     * Creates item with the give paramaters.
     * @param name
     * @param url
     * @param date
     * @param price
     * @param initialPrice
     * @param change
     */
    public void createItem(String name, String url, String date, double price, double initialPrice, double change){
        Item created = new Item(name, price, initialPrice, url, (float) change, date);
        addItem(created);
    }


}
