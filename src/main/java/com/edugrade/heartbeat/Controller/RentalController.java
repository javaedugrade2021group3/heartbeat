package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.RentalDAO;
import com.edugrade.heartbeat.Model.RentalEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RentalController implements Initializable {


    @FXML
    private TableView rental_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        RentalDAO rentalDAO = new RentalDAO();
        ObservableList<RentalEntity>rentalEntityObservableList = rentalDAO.getAll();

        rental_table.setItems(rentalEntityObservableList);

        TableColumn column0 = (TableColumn) rental_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("rentalId"));

        TableColumn column1 = (TableColumn) rental_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("rentalDate"));

        TableColumn column2 = (TableColumn) rental_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("inventoryId"));

        TableColumn column3 = (TableColumn) rental_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("customerId"));

        TableColumn column4 = (TableColumn) rental_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("returnDate"));

        TableColumn column5 = (TableColumn) rental_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory("staffId"));

        TableColumn column6 = (TableColumn) rental_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory("lastUpdate"));


    }
}






