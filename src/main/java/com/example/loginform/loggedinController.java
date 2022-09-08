package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loggedinController {

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane mainPanel;


    Stage stage;
    Alert alert;


    /*
  creates an Alert confirmation instance
  waits for user answer and if its OK then closes the program
*/
    public void exit(ActionEvent event) {

        //alert instance
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("");
        alert.setContentText("Are you sure? ");

        //checking if user wants to exit
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) mainPanel.getScene().getWindow();
            System.out.println("Successfully exited");
            stage.close();
        }
    }

}
