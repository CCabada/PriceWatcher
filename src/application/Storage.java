package application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Storage extends ItemManager{
    ItemManager manager = new ItemManager();

    public JSONArray toJSON(){
        return new JSONArray(getItems());
    }

    public static void toStorage(JSONArray array){
        try(FileWriter file = new FileWriter(new File("src/resources/items.json"))){
            file.write(array.toString());
        }catch (IOException ex){
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fromJSON() throws FileNotFoundException, JSONException {
        JSONTokener tokener = new JSONTokener(new FileInputStream(new File("src/resources/items.json")));
        JSONArray itemListJSON = new JSONArray(tokener);
        for (int i = 0; i < itemListJSON.length(); i++) {
            JSONObject itemJSON = itemListJSON.getJSONObject(i);
            manager.createItem(itemJSON.getString("name"), itemJSON.getString("URL"), itemJSON.getString("date"), itemJSON.getDouble("currentPrice"), itemJSON.getDouble("startingPrice"), itemJSON.getDouble("change"));
        }

    }


}
