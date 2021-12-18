package com.edugrade.heartbeat.Controller;


import com.edugrade.heartbeat.DAO.CountryDAO;
import com.edugrade.heartbeat.Model.CountryEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CountryController implements Initializable {

    @FXML
    private TableView country_table;


    @Override
    public void initialize(URL url, ResourceBundle resources) {
        CountryDAO countryDAO = new CountryDAO();
        ObservableList<CountryEntity> countryEntityObservableList = countryDAO.getAll();

        country_table.setItems(countryEntityObservableList);

        TableColumn column0 = (TableColumn) country_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("countryId"));

        TableColumn column1 = (TableColumn) country_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("country"));

        TableColumn column2 = (TableColumn) country_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}
