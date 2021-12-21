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

    /**
     * All the JavaFX elements
     * */
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
    @FXML
    private Button clear_fields_button;
    @FXML
    private Button create_new_entry_button;
    @FXML
    private Button delete_button;
    @FXML
    private TextField tf_id;
    @FXML
    private Button update_button;

    /**
     * This method is executed when the program starts, all the functionality is entered here.
     * */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show_all_button.setOnAction(event -> getAllCustomers());
        clear_fields_button.setOnAction(event -> clearSelectedFields());
        searchButton();
        selectFromTable();
        create_new_entry_button.setOnAction(event -> addNewEntry());
        delete_button.setOnAction(event -> deleteSelectedItem());
        update_button.setOnAction(event -> updateEntry());
    }

    /**
     * This method is used to update the entry.
     * */
    private void updateEntry() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.updateCustomer(
                Short.parseShort(tf_id.getText()),
                tf_firstName.getText(),
                tf_lastName.getText(),
                Byte.parseByte(tf_store.getText()),
                tf_email.getText(),
                Short.parseShort(tf_address.getText()),
                Byte.parseByte(tf_active.getText())
        );
    }

    /**
     * This method is used to delete an entry.
     * */
    private void deleteSelectedItem() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.deleteEntryById(Short.parseShort(tf_id.getText()));
    }

    /**
     * This method is used to add a new entry.
     * */
    private void addNewEntry() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.addNewCustomer(
                tf_firstName.getText(),
                tf_lastName.getText(),
                Byte.parseByte(tf_store.getText()),
                tf_email.getText(),
                Short.parseShort(tf_address.getText()),
                Byte.parseByte(tf_active.getText())
        );
    }

    /**
     * This method is used to clear the text fields from data.
     * */
    private void clearSelectedFields() {
        if (tf_firstName != null) {
            tf_firstName.setText("");
            tf_lastName.setText("");
            tf_store.setText("");
            tf_email.setText("");
            tf_address.setText("");
            tf_active.setText("");
            tf_id.setText("");
        }

    }

    /**
     * This method is used to select the data from a customer in the table and display the data in text fields.
     * */
    private void selectFromTable() {
        TableView.TableViewSelectionModel<CustomerEntity> selectionModel = customer_table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList<CustomerEntity> selectedItems = selectionModel.getSelectedItems();
        customer_table.setOnMouseClicked(MouseEvent -> selectedItems.forEach(e -> {
            tf_firstName.setText(e.getFirstName());
            tf_lastName.setText(e.getLastName());
            tf_store.setText(String.valueOf(e.getStoreId())); // Swap to store name later
            tf_email.setText(e.getEmail());
            tf_address.setText(String.valueOf(e.getAddressId())); // Swap to address later
            tf_active.setText(String.valueOf(e.getActive()));
            tf_id.setText(String.valueOf(e.getCustomerId()));
        }));
    }

    /**
     * This method is used to handle the search button.
     * */
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

    /**
     * This method is used to return a single customer to the customer table.
     * @param id The customer id.
     * */
    private void getCustomerById(short id) {
        CustomerDAO customerDAO = new CustomerDAO();
        ObservableList<CustomerEntity> customerEntityObservableList = customerDAO.searchById(id);
        tableResult(customerEntityObservableList);
    }

    /**
     * This method is used to return all customers, filling the table with data.
     * */
    private void getAllCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        ObservableList<CustomerEntity> customerEntityObservableList = customerDAO.getAll();
        tableResult(customerEntityObservableList);
    }

    /**
     * This method handles the data that should be shown in the table.
     * @param customerEntityObservableList ObservableList from the CustomerDAO class.
     * */
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
