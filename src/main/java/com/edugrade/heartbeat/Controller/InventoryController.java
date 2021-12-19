package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.InventoryDAO;
import com.edugrade.heartbeat.Model.InventoryEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private TableView inventory_table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        InventoryDAO inventoryDAO = new InventoryDAO();
        ObservableList <InventoryEntity> inventoryEntityObservableList = inventoryDAO.getAll();

        inventory_table.setItems(inventoryEntityObservableList);

        TableColumn column0 = (TableColumn) inventory_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("inventoryId"));
        TableColumn column1 = (TableColumn) inventory_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("filmId"));
        TableColumn column2 = (TableColumn) inventory_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("storeId"));
        TableColumn column3 = (TableColumn) inventory_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}
