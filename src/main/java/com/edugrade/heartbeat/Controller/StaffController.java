package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.StaffDAO;
import com.edugrade.heartbeat.Model.StaffEntity;
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

public class StaffController implements Initializable {
    @FXML
    private TableView staff_table;
    @FXML
    private Button search_button;
    @FXML
    private TextField tf_search;
    @FXML
    private Button show_all_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        search_button.setOnAction(event -> {
            if (tf_search.getText().equals("")) {
                getAllStaff();
            } else {
                getStaffById(Short.parseShort(tf_search.getText()));
                tf_search.clear();
            }
        });
        show_all_button.setOnAction(event -> getAllStaff());
    }

    private void getStaffById(short id) {
        StaffDAO staffDAO = new StaffDAO();
        ObservableList<StaffEntity> staffEntityObservableList = staffDAO.searchById(id);
        tableResult(staffEntityObservableList);
    }

    private void getAllStaff() {
        StaffDAO staffDAO = new StaffDAO();
        ObservableList<StaffEntity> staffEntityObservableList = staffDAO.getAll();
        tableResult(staffEntityObservableList);
    }

    private void tableResult(ObservableList<StaffEntity> staffEntityObservableList) {
        staff_table.setItems(staffEntityObservableList);

        TableColumn column0 = (TableColumn) staff_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("staffId"));

        TableColumn column1 = (TableColumn) staff_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn column2 = (TableColumn) staff_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn column3 = (TableColumn) staff_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("addressId"));

        TableColumn column4 = (TableColumn) staff_table.getColumns().get(4);
        column4.setCellValueFactory(new PropertyValueFactory("picture"));

        TableColumn column5 = (TableColumn) staff_table.getColumns().get(5);
        column5.setCellValueFactory(new PropertyValueFactory("email"));

        TableColumn column6 = (TableColumn) staff_table.getColumns().get(6);
        column6.setCellValueFactory(new PropertyValueFactory("storeId"));

        TableColumn column7 = (TableColumn) staff_table.getColumns().get(7);
        column7.setCellValueFactory(new PropertyValueFactory("active"));

        TableColumn column8 = (TableColumn) staff_table.getColumns().get(8);
        column8.setCellValueFactory(new PropertyValueFactory("username"));

        TableColumn column9 = (TableColumn) staff_table.getColumns().get(9);
        column9.setCellValueFactory(new PropertyValueFactory("password"));

        TableColumn column10 = (TableColumn) staff_table.getColumns().get(10);
        column10.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}
