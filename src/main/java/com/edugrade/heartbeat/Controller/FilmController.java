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
            column0.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn column1 = (TableColumn) film_table.getColumns().get(1);
            column1.setCellValueFactory(new PropertyValueFactory("firstName"));
            TableColumn column2 = (TableColumn) film_table.getColumns().get(2);
            column2.setCellValueFactory(new PropertyValueFactory("lastName"));
            TableColumn column3 = (TableColumn) film_table.getColumns().get(3);
            column3.setCellValueFactory(new PropertyValueFactory("address"));
            TableColumn column4 = (TableColumn) film_table.getColumns().get(4);
            column4.setCellValueFactory(new PropertyValueFactory("kdjflkjdf"));
        }
    }



}
