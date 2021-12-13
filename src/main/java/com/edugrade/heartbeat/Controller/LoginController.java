package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.StaffDAO;
import com.edugrade.heartbeat.Model.StaffEntity;
import com.edugrade.heartbeat.Utility.Util;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button button_login;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_login.setOnAction(event -> login(event, tf_username.getText(), pf_password.getText()));
    }

    /**
     * TODO - Try for existing user & try for wrong password
     * */

    public void login(ActionEvent event, String username, String password) {
        StaffDAO staffDAO = new StaffDAO();
        ObservableList<StaffEntity> staffEntityObservableList = staffDAO.getAll();

        for (StaffEntity staff : staffEntityObservableList) {
            if (staff.getPassword() != null) {
                if (staff.getPassword().equals(password)) {
                    Util.changeScene(event, "Admin Page", "/View/logged-in-view.fxml", username);
                }
            }
        }
    }
}