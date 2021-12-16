package com.edugrade.heartbeat.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/View/newloginview.fxml"));
        Parent root1 = FXMLLoader.load(getClass().getResource("/View/logged-in-view.fxml"));
        Scene scene = new Scene(root, 1000, 600);

        stage.setTitle("Rentals4You");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}