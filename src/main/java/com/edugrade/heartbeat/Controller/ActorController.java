package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.ActorDAO;
import com.edugrade.heartbeat.Model.ActorEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ActorController implements Initializable {

    @FXML
    private TableView actor_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ActorDAO actorDAO = new ActorDAO();
        ObservableList<ActorEntity> actorEntityObservableList = actorDAO.getAll();

        actor_table.setItems(actorEntityObservableList);

        TableColumn column0 = (TableColumn) actor_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("actorId"));

        TableColumn column1 = (TableColumn) actor_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn column2 = (TableColumn) actor_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn column3 = (TableColumn) actor_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}
