package application;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditController {

    @FXML
    JFXPanel CancelButton;


    public void SaveButtonAction(ActionEvent actionEvent) {
    }

    public void CancelAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


}
