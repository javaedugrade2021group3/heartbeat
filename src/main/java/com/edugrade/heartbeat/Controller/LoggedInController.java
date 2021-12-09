package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.CustomerDAO;
import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Utility.DBUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.PropertyValueException;

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
        button_logout.setOnAction(event -> DBUtil.changeScene(event, "Demo", "/View/login-view.fxml", null));
    }

    public void setUserInformation(String username) {
        label_admin.setText("Inloggad som: " + username);
    }
}