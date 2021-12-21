package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.LanguageDAO;
import com.edugrade.heartbeat.Model.LanguageEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class LanguageController implements Initializable {

    @FXML
    private TableView language_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LanguageDAO languageDAO = new LanguageDAO();
        ObservableList<LanguageEntity> languageEntityObservableList = languageDAO.getAll();

        language_table.setItems(languageEntityObservableList);

        TableColumn column0 = (TableColumn) language_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("languageId"));

        TableColumn column1 = (TableColumn) language_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn column2 = (TableColumn) language_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}
