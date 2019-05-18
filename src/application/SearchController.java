package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SearchController {
    @FXML
    Button CancelButton;

    public void SearchItemAction(ActionEvent actionEvent) {
    }

    public void CancelItemAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }
}
