package com.example.loginform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainStyles.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login Form");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        //handling exit look exit function
        stage.setOnCloseRequest(event ->{
            event.consume();
            exit(stage);
        });



    }
    public void exit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("");
        alert.setContentText("Are you sure? ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Successfully exited");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}