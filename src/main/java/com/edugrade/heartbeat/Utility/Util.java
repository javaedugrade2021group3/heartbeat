package com.edugrade.heartbeat.Utility;

import com.edugrade.heartbeat.Controller.LoggedInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Util {

    public static void changeScene(ActionEvent event, String title, String fxmlFile, String username) {
        Parent root = null;

        if (username != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Util.class.getResource(fxmlFile));
                root = fxmlLoader.load();
                LoggedInController loggedInController = fxmlLoader.getController();
                loggedInController.setUserInformation(username);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(Util.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}
