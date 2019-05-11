package application;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Storage extends ItemManager{

    public JSONArray toJSON(){
        return new JSONArray(getItems());
    }

    public void toStorage(JSONArray array){
        try(FileWriter file = new FileWriter(new File("src/resources/items.json"))){
            file.write(array.toString());
        }catch (IOException ex){
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fromJSON() throws FileNotFoundException {
        JSONTokener tokener = new JSONTokener(new FileInputStream(new File("src/resources/items.json")));
        JSONArray productListJSON = new JSONArray(tokener);
        for (int i = 0; i < productListJSON.length(); i++) {
            JSONObject itemJSON = itemListJSON.getJSONObject(i);
            create(itemJSON.getString("name"), itemJSON.getDate("date"), itemJSON.getDouble("currentPrice"),
                    itemJSON.getDouble("startingPrice"),
                    itemJSON.getString("URL"),
                    itemJSON.getDouble("change")
            );
        }

    }


}
