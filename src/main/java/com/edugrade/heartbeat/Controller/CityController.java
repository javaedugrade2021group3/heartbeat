package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.CityDAO;
import com.edugrade.heartbeat.Model.CityEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CityController implements Initializable  {

    @FXML
    private TableView city_table;
   /* @FXML
    private Button search_button;
    @FXML
    private TextField tf_search;
     */
    @FXML
    private Button show_all_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        show_all_button.setOnAction(event -> getAllCitys());
    }
/*
    private void getCitysById(short id) {
        CityDAO cityDAO = new CityDAO();
        ObservableList<CityEntity> cityEntityObservableList = cityDAO.searchById(id);
        tableResult(cityEntityObservableList);

    }
*/
    private void getAllCitys() {
        CityDAO cityDAO = new CityDAO();
        ObservableList<CityEntity> cityEntityObservableList = cityDAO.getAll();
        tableResult(cityEntityObservableList);
    }

    private void tableResult(ObservableList<CityEntity> cityEntityObservableList) {
        city_table.setItems(cityEntityObservableList);

        TableColumn column0 = (TableColumn) city_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("cityId"));

        TableColumn column1 = (TableColumn) city_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("city"));

        TableColumn column2 = (TableColumn) city_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("countryId"));

        TableColumn column3 = (TableColumn) city_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}