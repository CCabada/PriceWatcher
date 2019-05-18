package application;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Provides functionality to the edit view.
 */
public class EditController {

    @FXML
    JFXPanel CancelButton;

    /**
     * Saves the changes made to the selected item.
     * @param actionEvent
     */
    public void SaveButtonAction(ActionEvent actionEvent) {
    }

    /**
     * Cancels the change, and closes the window.
     * @param actionEvent
     */
    public void CancelAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


}
