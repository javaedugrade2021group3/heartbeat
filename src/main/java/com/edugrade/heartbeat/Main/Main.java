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
        //Parent root = FXMLLoader.load(getClass().getResource("/View/login-view.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/View/logged-in-view.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}