package com.edugrade.heartbeat.Controller;


import com.edugrade.heartbeat.DAO.CategoryDAO;
import com.edugrade.heartbeat.Model.CategoryEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable{

    @FXML
    private TableView category_table;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoryDAO categoryDAO = new CategoryDAO();
        ObservableList<CategoryEntity> categoryEntityObservableList = categoryDAO.getAll();

        category_table.setItems(categoryEntityObservableList);

        TableColumn column0 = (TableColumn) category_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("categoryId"));

        TableColumn column1 = (TableColumn) category_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn column2 = (TableColumn) category_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}

