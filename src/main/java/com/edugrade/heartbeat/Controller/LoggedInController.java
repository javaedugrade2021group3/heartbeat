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

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Label label_admin;
    @FXML
    private TabPane tabPane;
    /**
     *  movieTab + movieTabController
     * */
    @FXML
    private Tab movieTab;

    @FXML
    private TableColumn customer_id;

    @FXML
    private TableView customer_table;
    private ObservableList<CustomerEntity> customerEntityObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CustomerDAO query = new CustomerDAO();
        customerEntityObservableList = query.getAll();



        // Logga ut knappen -> Tar en tillbaka till login sidan.
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtil.changeScene(event, "Demo", "/View/login-view.fxml", null);
            }
        });
    }

    public void setUserInformation(String username) {
        label_admin.setText("Inloggad som: " + username);
        //label_data.setText("Data kommer stå här");
    }
}