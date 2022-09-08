package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    private HashMap<String, String> usersData = new HashMap<String, String>();
    private Alert alert;


    public boolean checkPassword (){
        if (usersData.get(usernameField.getText()) != null) {
            if (usersData.get(usernameField.getText()).equals(passwordField.getText()))
                return true;
        }
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("wrong password");
        alert.setHeaderText("");
        alert.setContentText("your login or password are wrong");
        alert.showAndWait();

        return false;

    }

    /*
    login function changes scenes between main and logged in
    there are two ways of implementation one was commented

     need to handle better IOException
     */

    public void login (ActionEvent event){

        if (checkPassword()) {

            try {
//            Parent root = FXMLLoader.load(getClass().getResource("loggedinScene.fxml"));
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("loggedinScene.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                System.out.println(" Error: " + e.getMessage());

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usersData.put("admin", "admin");
        usersData.put("myLogin", "myPassword");
        usersData.put("user", "1234");

    }
}