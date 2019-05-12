package application;

import java.util.ArrayList;
import java.util.List;

/**
 * Item Class
 * Attributes
 */
public class ItemManager {
    
    private List<Item> listItems;
    
    public ItemManager(){
        this.listItems = new ArrayList<>();
    }
    
    public void addItem(Item item){
        this.getItems().add(item);
    }
    public void deleteItem(int item){
        this.getItems().remove(item);
    }
    
    public void removeItem(){
        this.listItems = new ArrayList<>();
    }

    public List<Item> getItems() {
        return this.listItems;
    }

    public boolean  isEmpty(){
        return getItems()== null;
    }
    
    public void createItem(String name, String url, String date, double price, double initialPrice, double change){
        Item created = new Item(name, price, initialPrice, url, (float) change, date);
        addItem(created);
    }


}
