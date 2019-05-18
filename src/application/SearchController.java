package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SearchController {
    @FXML
    Button CancelButton;

    /**
     * Provides functionality to the search button. Searches item by name and/or group.
     * @param actionEvent
     */
    public void SearchItemAction(ActionEvent actionEvent) {
    }

    /**
     * Cancels and closes window.
     * @param actionEvent
     */
    public void CancelItemAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }
}
