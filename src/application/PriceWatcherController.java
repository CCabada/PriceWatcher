package application;
// Cell Factory
// ListView
//Observable view

import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

public class PriceWatcherController {
    @FXML
    static ListView listView = new ListView();
    ObservableList list;
    ItemManager manager = new ItemManager();
    TextField URLField;
    private JFXPanel CancelButton;

    /**
     * Handle action related to input (in this case specifically only responds to
     * keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event) throws IOException
    {
        if (event instanceof KeyEvent)
        {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isAltDown() && keyEvent.getCode() == KeyCode.A)
                provideAboutFunctionality();
            if(keyEvent.isAltDown() && keyEvent.getCode() == KeyCode.C)
                provideCheckPricesFunctionality();
            if(keyEvent.isAltDown() && keyEvent.getCode() == KeyCode.S)
                provideSearchFunctionality();

        }
    }

    private void provideSearchFunctionality() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("'SearchView.fxml"));
        Stage itemStage = new Stage();
        itemStage.setTitle("Search Item");
        itemStage.setScene(new Scene(root, 630, 730));
        itemStage.sizeToScene();
        itemStage.show();


    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality()
    {
        Stage newStage = new Stage();
        BorderPane root = new BorderPane();
        Text name = new Text("Application done by: Carlos Cabada \n Price Watcher Version: 3.0");
        root.setCenter(name);

        Scene stageScene = new Scene(root, 300, 300);
        newStage.setScene(stageScene);
        newStage.show();

    }
    private void provideCheckPricesFunctionality(){

    }


    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        listView.setItems(list);
    }
    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void AboutAction(ActionEvent event){ provideAboutFunctionality();}

    /**
     * Handles Exit action event. Closes the application.
     * @param actionEvent
     */
    public void ExitAction(ActionEvent actionEvent) {System.exit(0);}

    /**
     * Refreshes application, it checks the price for every item in the list.
     * @param actionEvent
     */
    public void CheckPricesAction(ActionEvent actionEvent) {provideCheckPricesFunctionality();}

    /**
     *
     * @param actionEvent
     */

    public void AddPricesAction(ActionEvent actionEvent) {System.out.println("You clicked on Add Price!");
    }

    public void SearchAction(ActionEvent actionEvent) throws IOException{ provideSearchFunctionality();}

    public void OldestAction(ActionEvent actionEvent) {System.out.println("You clicked o5");
    }

    public void NewestAction(ActionEvent actionEvent) {
    }

    public void LowAction(ActionEvent actionEvent) {
    }

    public void PriceChangeAction(ActionEvent actionEvent) {
    }

    public void DescendingAction(ActionEvent actionEvent) {
    }

    public void AscendingAction(ActionEvent actionEvent) {
    }

    public void HighAction(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent
     */
    public void UrlButtonAction(ActionEvent actionEvent) {

        Desktop d1 = Desktop.getDesktop();
        try {
            if (manager.isEmpty()) {
                if (URLField.getText() != null) {
                    d1.browse(new URI(URLField.getText()));   //TODO Only allow this if there is any items on the list.
                } else {
                    Stage newStage = new Stage();
                    BorderPane root = new BorderPane();
                    Text no = new Text("No URL!!!!");
                    root.setCenter(no);

                    Scene stageScene = new Scene(root, 300, 300);
                    newStage.setScene(stageScene);
                    newStage.show();

                }
            }
        } catch(IOException | URISyntaxException e2){
            e2.printStackTrace();
        }

    }
    public static void displayItems(ListView list){
        listView = list;

    }

    public void AddButtonAction(ActionEvent actionEvent) throws IOException {
        newItemAction(actionEvent);

    }

    public void SearchButtonAction(ActionEvent actionEvent) throws IOException {
        SearchAction(actionEvent);
    }

    public void newItemAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddItemView.fxml"));
        Stage itemStage = new Stage();
        itemStage.setTitle("Add New Item");
        itemStage.setScene(new Scene(root, 630, 730));
        itemStage.sizeToScene();
        itemStage.show();

    }

    public void editAction(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("editView.fxml"));
        Stage itemStage = new Stage();
        itemStage.setTitle("Edit Item");
        itemStage.setScene(new Scene(root, 630, 730));
        itemStage.sizeToScene();
        itemStage.show();
    }


    public void helpAction(ActionEvent actionEvent) {
    }

    public void cancelAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
