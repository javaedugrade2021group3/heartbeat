package com.edugrade.heartbeat.Controller;


import com.edugrade.heartbeat.DAO.AddressDAO;
import com.edugrade.heartbeat.Model.AddressEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddressController implements Initializable {

    @FXML
    private TableView address_table;


    @Override
    public void initialize(URL url, ResourceBundle resources) {
        AddressDAO addressDAO = new AddressDAO();
        ObservableList<AddressEntity> addressEntityObservableList = addressDAO.getAll();

        address_table.setItems(addressEntityObservableList);

        TableColumn column0 = (TableColumn) address_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("addressId"));

        TableColumn column1 = (TableColumn) address_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("address"));

        TableColumn column2 = (TableColumn) address_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("address2"));

        TableColumn column3 = (TableColumn) address_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("district"));

        TableColumn column4 = (TableColumn) address_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("cityId"));

        TableColumn column5 = (TableColumn) address_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory("postalCode"));

        TableColumn column6 = (TableColumn) address_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory("phone"));

        TableColumn column7 = (TableColumn) address_table.getColumns().get(7);
        column7.setCellValueFactory(new PropertyValueFactory("lastUpdate"));
    }
}