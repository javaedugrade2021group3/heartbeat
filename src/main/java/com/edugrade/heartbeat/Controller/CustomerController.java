package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.CustomerDAO;
import com.edugrade.heartbeat.Model.CustomerEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private TableView<CustomerEntity> customer_table;
    @FXML
    private Button search_button;
    @FXML
    private TextField tf_search;
    @FXML
    private Button show_all_button;
    @FXML
    private TextField tf_firstName;
    @FXML
    private TextField tf_lastName;
    @FXML
    private TextField tf_address;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_active;
    @FXML
    private TextField tf_store;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show_all_button.setOnAction(event -> getAllCustomers());
        searchButton();
        selectFromTable();
    }

    private void selectFromTable() {
        TableView.TableViewSelectionModel<CustomerEntity> selectionModel = customer_table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList<CustomerEntity> selectedItems = selectionModel.getSelectedItems();
        customer_table.setOnMouseClicked(MouseEvent -> {
            selectedItems.forEach(e -> {
                tf_firstName.setText(e.getFirstName());
                tf_lastName.setText(e.getLastName());
                tf_store.setText(String.valueOf(e.getStoreId())); // Swap to store name later
                tf_email.setText(e.getEmail());
                tf_address.setText(String.valueOf(e.getAddressId())); // Swap to address later
                tf_active.setText(String.valueOf(e.getActive()));
            });
        });
    }

    private void searchButton() {
        search_button.setOnAction(event -> {
            if (tf_search.getText().equals("")) {
                getAllCustomers();
            } else {
                getCustomerById(Short.parseShort(tf_search.getText()));
                tf_search.clear();
            }
        });
    }

    private void getCustomerById(short id) {
        CustomerDAO customerDAO = new CustomerDAO();
        ObservableList<CustomerEntity> customerEntityObservableList = customerDAO.searchById(id);
        tableResult(customerEntityObservableList);
    }

    private void getAllCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        ObservableList<CustomerEntity> customerEntityObservableList = customerDAO.getAll();
        tableResult(customerEntityObservableList);
    }

    private void tableResult(ObservableList<CustomerEntity> customerEntityObservableList) {
        customer_table.setItems(customerEntityObservableList);

        TableColumn column0 = (TableColumn) customer_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("customerId"));

        TableColumn column1 = (TableColumn) customer_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("storeId"));

        TableColumn column2 = (TableColumn) customer_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn column3 = (TableColumn) customer_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn column4 = (TableColumn) customer_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("email"));

        TableColumn column5 = (TableColumn) customer_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory("addressId"));

        TableColumn column6 = (TableColumn) customer_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory("active"));

        TableColumn column7 = (TableColumn) customer_table.getColumns().get(7);
        column7.setCellValueFactory(new PropertyValueFactory("createDate"));

        TableColumn column8 = (TableColumn) customer_table.getColumns().get(8);
        column8.setCellValueFactory(new PropertyValueFactory("lastUpdate"));
    }
}
