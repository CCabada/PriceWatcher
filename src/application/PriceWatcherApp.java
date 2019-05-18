package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PriceWatcherApp extends Application {


    /**
     * Starts the application by loading the PriceWatcherViewWList.fxml
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PriceWatcherViewWList.fxml"));
        primaryStage.setTitle("Price Finder");
        primaryStage.setScene(new Scene(root, 630, 730));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     *Main method.
      * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
