package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddItemController {
    @FXML
    private TextField NameField ;
    @FXML
    private TextField URLField;
    @FXML
    private TextField PriceField;


    public ListView<Item> listView = new ListView<>();
    public ObservableList<Item> items;


    public ListView SaveItemAction(ActionEvent actionEvent) {

        if(NameField.getText() != null && PriceField.getText() != null && URLField.getText() != null){
            Item item = PriceWatcherModel.addItem(NameField.getText(), Double.parseDouble(PriceField.getText()), URLField.getText());
            listView.getItems().add(item);
            items = listView.getSelectionModel().getSelectedItems();

        }

        return listView;
    }



}
