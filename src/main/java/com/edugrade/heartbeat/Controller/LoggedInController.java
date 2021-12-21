package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.Utility.Util;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Label label_admin;
    @FXML
    private Tab customerTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Logga ut knappen -> Tar en tillbaka till login sidan.
        button_logout.setOnAction(event -> Util.changeScene(event, "Rentals4You", "/View/newloginview.fxml", null));
    }

    public void setUserInformation(String username) {
        label_admin.setText("Inloggad som: " + username);
    }
}