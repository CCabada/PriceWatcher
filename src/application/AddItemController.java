package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddItemController {
    @FXML
    private TextField NameField ;
    @FXML
    private TextField URLField;
    @FXML
    private TextField PriceField;


    public ListView<Item> listView = new ListView<>();
    public ObservableList<Item> items;

    @FXML
    Button AddItemButton;
    @FXML
    Button CancelButton;
    Alert a = new Alert(Alert.AlertType.NONE);


    public void AddItemAction(ActionEvent actionEvent) {

        if(NameField.getText() != null && PriceField.getText() != null && URLField.getText() != null) {
            Item item = PriceWatcherModel.addItem(NameField.getText(), Double.parseDouble(PriceField.getText()), URLField.getText());
            listView.getItems().add(item);
            items = listView.getSelectionModel().getSelectedItems();
        } else if(NameField.getText() == "" || PriceField.getText() == "" || URLField.getText() == ""){
            Stage alert = new Stage();
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Error");
            alert.setWidth(250);
            Label label = new Label();
            label.setText("Make sure all of the information is included.");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e-> alert.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);

            Scene scene = new Scene(layout);
            alert.setScene(scene);
            alert.showAndWait();



        }
        listView.setCellFactory(ComboBoxListCell.forListView(items));
        PriceWatcherController.displayItems(listView);
        CancelItemAction(actionEvent); // Closes Window

    }


    public void CancelItemAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }
}
