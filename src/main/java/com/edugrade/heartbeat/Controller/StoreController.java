package com.edugrade.heartbeat.Controller;


import com.edugrade.heartbeat.DAO.StoreDAO;
import com.edugrade.heartbeat.Model.StoreEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    @FXML
    private TableView store_table;


    @Override
    public void initialize(URL url, ResourceBundle resources) {
        StoreDAO storeDAO = new StoreDAO();
        ObservableList<StoreEntity> storeEntityObservableList = storeDAO.getAll();

        store_table.setItems(storeEntityObservableList);

        TableColumn column0 = (TableColumn) store_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("storeId"));

        TableColumn column1 = (TableColumn) store_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("managerStaffId"));

        TableColumn column2 = (TableColumn) store_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("addressId"));

        TableColumn column3 = (TableColumn) store_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}
