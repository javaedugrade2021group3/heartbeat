package com.edugrade.heartbeat.Controller;


import com.edugrade.heartbeat.DAO.FilmDAO;
import com.edugrade.heartbeat.Model.FilmEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class FilmController implements Initializable {

    @FXML
    private TableView film_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FilmDAO filmDAO = new FilmDAO();
        ObservableList<FilmEntity> filmEntityObservableList = filmDAO.getAll();

        film_table.setItems(filmEntityObservableList);

        TableColumn column0 = (TableColumn) film_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("filmId"));

        TableColumn column1 = (TableColumn) film_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("title"));
        
        TableColumn column2 = (TableColumn) film_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("description"));
        
        
        TableColumn column3 = (TableColumn) film_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("releaseYear"));

        TableColumn column4 = (TableColumn) film_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("languageId"));

        TableColumn column5 = (TableColumn) film_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory("originalLanguageId"));

        TableColumn column6 = (TableColumn) film_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory("rentalDuration"));

        TableColumn column7 = (TableColumn) film_table.getColumns().get(7);
        column7.setCellValueFactory(new PropertyValueFactory("rentalRate"));

        TableColumn column8 = (TableColumn) film_table.getColumns().get(8);
        column8.setCellValueFactory(new PropertyValueFactory("length"));

        TableColumn column9 = (TableColumn) film_table.getColumns().get(9);
        column9.setCellValueFactory(new PropertyValueFactory("replacementCost"));

        TableColumn column10 = (TableColumn) film_table.getColumns().get(10);
        column10.setCellValueFactory(new PropertyValueFactory("lastUpdate"));
        

    }
}




