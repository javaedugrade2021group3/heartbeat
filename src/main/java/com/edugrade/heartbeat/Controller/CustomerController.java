package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.CustomerDAO;
import com.edugrade.heartbeat.Model.CustomerEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private TableView customer_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CustomerDAO query = new CustomerDAO();
        ObservableList<CustomerEntity> customerEntityObservableList = query.getAll();

        customer_table.setItems(customerEntityObservableList);

        TableColumn column0 = (TableColumn) customer_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn column1 = (TableColumn) customer_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn column2 = (TableColumn) customer_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastName"));
        TableColumn column3 = (TableColumn) customer_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("Address"));
        TableColumn column4 = (TableColumn) customer_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("PhoneNumber"));
    }
}
