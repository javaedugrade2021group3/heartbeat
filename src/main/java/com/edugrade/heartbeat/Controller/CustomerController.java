package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.CustomerAddressDAO;
import com.edugrade.heartbeat.DAO.CustomerDAO;
import com.edugrade.heartbeat.DAO.StoreAddressDAO;
import com.edugrade.heartbeat.Model.AddressEntity;
import com.edugrade.heartbeat.Model.CustomerAddressEntity;
import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Model.StoreAddressEntity;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    /**
     * All the JavaFX elements
     * */
    @FXML
    private TableView<CustomerEntity> customer_table;
    @FXML
    private TableView<CustomerAddressEntity> address_table;
    @FXML
    private TableView<StoreAddressEntity> store_table;
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
    @FXML
    private Button test_button;

    private final CustomerDAO customerDAO = new CustomerDAO();

    /**
     * This method is executed when the program starts, everything that needs
     *  to run when the application starts should be entered here.
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
     * Enable keyboard shortcuts command + s on mac, however there's no underscore in 'Sök'
     * doesn't seem to work propperly on mac. (CURRENTLY NOT IMPLEMENTED)
     * */
    private void buttonController() {
        search_button.setText("_Sök");
        search_button.setMnemonicParsing(true);
        search_button.getScene().getAccelerators().put(
                new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN),
                () -> search_button.fire()
        );
    }

    /**
     * This method is used to update an entry.
     * */
    private void updateEntry() {
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
        customerDAO.deleteEntryById(Short.parseShort(tf_id.getText()));
    }

    /**
     * This method is used to add a new entry.
     * */
    private void addNewEntry() {
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
            tf_store.setText(String.valueOf(e.getStoreId()));
            tf_email.setText(e.getEmail());
            tf_address.setText(String.valueOf(e.getAddressId()));
            tf_active.setText(String.valueOf(e.getActive()));
            tf_id.setText(String.valueOf(e.getCustomerId()));
            getCustomerAddress(Short.parseShort(tf_id.getText()));
            getStoreAddress(Short.parseShort(tf_store.getText()));
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
        ObservableList<CustomerEntity> customerEntityObservableList = customerDAO.searchById(id);
        tableResult(customerEntityObservableList);
    }

    /**
     * This method is used to return all customers, filling the customer table with data.
     * */
    private void getAllCustomers() {
        ObservableList<CustomerEntity> customerEntityObservableList = customerDAO.getAll();
        tableResult(customerEntityObservableList);
    }

    /**
     * This method is used to get the Customer's Address information into the address table
     * @param id The customer id.
     * */
    private void getCustomerAddress(short id) {
        CustomerAddressDAO customerAddressDAO = new CustomerAddressDAO();
        ObservableList<CustomerAddressEntity> customerAddressEntityObservableList = customerAddressDAO.searchById(id);
        address_table.setItems(customerAddressEntityObservableList);


        TableColumn column0 = address_table.getColumns().get(0);
        column0.setCellValueFactory((Callback<TableColumn.CellDataFeatures<CustomerAddressEntity, String>, ObservableValue>) param -> {
            AddressEntity address;
            address = param.getValue().getAddressEntity();
            return new SimpleIntegerProperty(address.getAddressId());
        });
        TableColumn column1 = address_table.getColumns().get(1);
        column1.setCellValueFactory((Callback<TableColumn.CellDataFeatures<CustomerAddressEntity, String>, ObservableValue>) param -> {
            AddressEntity address;
            address = param.getValue().getAddressEntity();
            return new SimpleStringProperty(address.getAddress());
        });
    }

    /**
     * This method is used to get the Store's Address information into the store table.
     * @param id The customer id.
     * */
    private void getStoreAddress(short id) {
        StoreAddressDAO storeAddressDAO = new StoreAddressDAO();
        ObservableList<StoreAddressEntity> c = storeAddressDAO.searchById(id);
        store_table.setItems(c);

        TableColumn column0 = store_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory<StoreAddressEntity, String>("storeId"));

        TableColumn column1 = store_table.getColumns().get(1);
        column1.setCellValueFactory((Callback<TableColumn.CellDataFeatures<StoreAddressEntity, String>, ObservableValue>) param -> {
            AddressEntity address;
            address = param.getValue().getAddressEntity();
            return new SimpleStringProperty(address.getAddress());
        });
    }

    /**
     * This method handles the data that should be shown in the table.
     * @param customerEntityObservableList ObservableList from the CustomerDAO class.
     * */
    private void tableResult(ObservableList<CustomerEntity> customerEntityObservableList) {
        customer_table.setItems(customerEntityObservableList);

        TableColumn column0 = customer_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("customerId"));

        TableColumn column1 = customer_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("storeId"));

        TableColumn column2 = customer_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn column3 = customer_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn column4 = customer_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("email"));

        TableColumn column5 = customer_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory("addressId"));

        TableColumn column6 = customer_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory("active"));

        TableColumn column7 = customer_table.getColumns().get(7);
        column7.setCellValueFactory(new PropertyValueFactory("createDate"));

        TableColumn column8 = customer_table.getColumns().get(8);
        column8.setCellValueFactory(new PropertyValueFactory("lastUpdate"));
    }
}
