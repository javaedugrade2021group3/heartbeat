package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.StaffAddressDAO;
import com.edugrade.heartbeat.DAO.StaffDAO;
import com.edugrade.heartbeat.DAO.StoreAddressDAO;
import com.edugrade.heartbeat.Model.AddressEntity;
import com.edugrade.heartbeat.Model.StaffAddressEntity;
import com.edugrade.heartbeat.Model.StaffEntity;
import com.edugrade.heartbeat.Model.StoreAddressEntity;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {
    @FXML
    private TableView<StaffEntity> staff_table;
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
    private TextField tf_store;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_active;
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;
    @FXML
    private Button clear_fields_button;
    @FXML
    private Button create_new_entry_button;
    @FXML
    private Button delete_button;
    @FXML
    private Button update_button;
    @FXML
    private TextField tf_storeAddress;
    @FXML
    private TextField tf_storeAddressId;
    @FXML
    private TextField tf_staffAddress;
    @FXML
    private TextField tf_staffAddressId;

    @FXML
    private Button test_button;

    private final StaffDAO staffDAO = new StaffDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update_button.setOnAction(event -> updateEntry());
        delete_button.setOnAction(event -> deleteSelectedItem());
        create_new_entry_button.setOnAction(event -> addNewEntry());
        clear_fields_button.setOnAction(event -> clearSelectedFields());
        searchButton();
        show_all_button.setOnAction(event -> getAllStaff());
        selectFromTable();
    }

    private void getStoreAddress(short id) {
        StoreAddressDAO storeAddressDAO = new StoreAddressDAO();
        ObservableList<StoreAddressEntity> storeAddressEntityObservableList = storeAddressDAO.searchById(id);
        tf_storeAddressId.setText(String.valueOf(storeAddressEntityObservableList.get(0).getStoreId()));
        tf_storeAddress.setText(storeAddressEntityObservableList.get(0).getAddressEntity().getAddress());

    }

    private void getStaffAddress(short id) {
        StaffAddressDAO staffAddressDAO = new StaffAddressDAO();
        ObservableList<StaffAddressEntity> staffAddressEntityObservableList = staffAddressDAO.searchById(id);
        tf_staffAddressId.setText(String.valueOf(staffAddressEntityObservableList.get(0).getAddressEntity().getAddressId()));
        tf_staffAddress.setText(staffAddressEntityObservableList.get(0).getAddressEntity().getAddress());
    }

    private void clearSelectedFields() {
        if (tf_firstName != null) {
            tf_firstName.setText("");
            tf_lastName.setText("");
            tf_store.setText("");
            tf_active.setText("");
            tf_address.setText("");
            tf_email.setText("");
            tf_username.setText("");
            pf_password.setText("");
            tf_id.setText("");
        }
    }

    private void selectFromTable() {
        TableView.TableViewSelectionModel<StaffEntity> selectionModel = staff_table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList<StaffEntity> selectedItems = selectionModel.getSelectedItems();
        staff_table.setOnMouseClicked(MouseEvent -> selectedItems.forEach(e -> {
            tf_firstName.setText(e.getFirstName());
            tf_lastName.setText(e.getLastName());
            tf_store.setText(String.valueOf(e.getStoreId()));
            tf_active.setText(String.valueOf(e.getActive()));
            tf_address.setText(String.valueOf(e.getAddressId()));
            tf_email.setText(e.getEmail());
            tf_username.setText(e.getUsername());
            pf_password.setText(e.getPassword());
            tf_id.setText(String.valueOf(e.getStaffId()));
            getStaffAddress(Short.parseShort(tf_id.getText()));
            getStoreAddress(Short.parseShort(tf_store.getText()));
        }));
    }

    private void addNewEntry() {
        staffDAO.addNewStaff(
                tf_firstName.getText(),
                tf_lastName.getText(),
                Short.parseShort(tf_address.getText()),
                tf_email.getText(),
                Byte.parseByte(tf_store.getText()),
                Byte.parseByte(tf_active.getText()),
                tf_username.getText(),
                pf_password.getText()
        );
    }

    private void deleteSelectedItem() {
        staffDAO.deleteEntryById(Short.parseShort(tf_id.getText()));
    }

    private void updateEntry() {
        staffDAO.updateStaff(
                Short.parseShort(tf_id.getText()),
                tf_firstName.getText(),
                tf_lastName.getText(),
                Short.parseShort(tf_address.getText()),
                tf_email.getText(),
                Byte.parseByte(tf_store.getText()),
                Byte.parseByte(tf_active.getText()),
                tf_username.getText(),
                pf_password.getText()
        );

    }

    private void searchButton() {
        search_button.setOnAction(event -> {
            if (tf_search.getText().equals("")) {
                getAllStaff();
            } else {
                getStaffById(Short.parseShort(tf_search.getText()));
                tf_search.clear();
            }
        });
    }

    private void getStaffById(short id) {
        ObservableList<StaffEntity> staffEntityObservableList = staffDAO.searchById(id);
        tableResult(staffEntityObservableList);
    }

    private void getAllStaff() {
        ObservableList<StaffEntity> staffEntityObservableList = staffDAO.getAll();
        tableResult(staffEntityObservableList);
    }

    private void tableResult(ObservableList<StaffEntity> staffEntityObservableList) {
        staff_table.setItems(staffEntityObservableList);

        TableColumn column0 = staff_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("staffId"));

        TableColumn column1 = staff_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("firstName"));

        TableColumn column2 = staff_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("lastName"));

        TableColumn column3 = staff_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("addressId"));

        TableColumn column4 = staff_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("picture"));

        TableColumn column5 = staff_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("email"));

        TableColumn column6 = staff_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("storeId"));

        TableColumn column7 = staff_table.getColumns().get(7);
        column7.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("active"));

        TableColumn column8 = staff_table.getColumns().get(8);
        column8.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("username"));

        TableColumn column9 = staff_table.getColumns().get(9);
        column9.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("password"));

        TableColumn column10 = staff_table.getColumns().get(10);
        column10.setCellValueFactory(new PropertyValueFactory<StaffEntity, String>("lastUpdate"));
    }
}
