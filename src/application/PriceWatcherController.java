package application;
// Cell Factory
// ListView
//Observable view
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
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
    private MenuBar menuBar;
    @FXML
    private Button urlButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button newItemButton;
    @FXML
    private Button editButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button helpButton;



    @FXML
    private TextField NameField ;
    @FXML
    private TextField URLField;
    @FXML
    private TextField PriceField;
    @FXML
    private TextField ChangeField;
    @FXML
    private TextField AddedField;
    @FXML
    private ComboBox GroupField;
    @FXML
    private TextField NameField2;
    @FXML
    private TextField URLField2;
    @FXML
    private TextField PriceField2;
    @FXML
    private TextField ChangeField2;
    @FXML
    private TextField AddedField2;
    @FXML
    private TextField GroupField2;

    public ListView<Item> listView = new ListView<>();
    public ObservableList<Item> items;


    /**
     * Handle action related to input (in this case specifically only responds to
     * keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event)
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

    private void provideSearchFunctionality() {
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


    public void initialize(java.net.URL arg0, ResourceBundle arg1) { menuBar.setFocusTraversable(true);    }
    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void AboutAction(ActionEvent event){ provideAboutFunctionality();}
    public void ExitAction(ActionEvent actionEvent) {System.exit(0);}

    public void CheckPricesAction(ActionEvent actionEvent) {provideCheckPricesFunctionality();}

    public void AddPricesAction(ActionEvent actionEvent) {System.out.println("You clicked on Add Price!");
    }

    public void SearchAction(ActionEvent actionEvent) { provideSearchFunctionality();}

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
            if(URLField.getText() != "") {
                d1.browse(new URI(URLField.getText()));
            }else{
                Stage newStage = new Stage();
                BorderPane root = new BorderPane();
                Text no = new Text("No URL!!!!");
                root.setCenter(no);

                Scene stageScene = new Scene(root, 300, 300);
                newStage.setScene(stageScene);
                newStage.show();

            }

        } catch (IOException | URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    public void AddButtonAction(ActionEvent actionEvent) throws IOException {
        newItemAction(actionEvent);
    }

    public void SearchButtonAction(ActionEvent actionEvent) {
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

    public void cancelAction(ActionEvent actionEvent) {
    }

    public void helpAction(ActionEvent actionEvent) {
    }

//    public void SaveItemAction(ActionEvent actionEvent) {
//
//        if(NameField.getText() != null && PriceField.getText() != null && URLField.getText() != null){
//            Item item = PriceWatcherModel.addItem(NameField.getText(), Double.parseDouble(PriceField.getText()), URLField.getText());
//            listView.getItems().add(item);
//            items = listView.getSelectionModel().getSelectedItems();
//
//        }
//
//        //if(actionEvent)
//
//    }

//    public static void DisplayItem(Item item, float change, Date date){
//        NameField

//    }
}
