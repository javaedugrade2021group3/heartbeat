package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.PaymentDAO;
import com.edugrade.heartbeat.Model.PaymentEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private TableView payment_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PaymentDAO paymentDAO = new PaymentDAO();
        ObservableList<PaymentEntity> paymentEntityObservableList = paymentDAO.getAll();

        payment_table.setItems(paymentEntityObservableList);

        TableColumn column0 = (TableColumn) payment_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("paymentId"));

        TableColumn column1 = (TableColumn) payment_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("customerId"));

        TableColumn column2 = (TableColumn) payment_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("staffId"));

        TableColumn column3 = (TableColumn) payment_table.getColumns().get(3);
        column2.setCellValueFactory(new PropertyValueFactory("rentalId"));

        TableColumn column4 = (TableColumn) payment_table.getColumns().get(4);
        column2.setCellValueFactory(new PropertyValueFactory("amount"));

        TableColumn column5 = (TableColumn) payment_table.getColumns().get(5);
        column2.setCellValueFactory(new PropertyValueFactory("paymentDate"));

        TableColumn column6 = (TableColumn) payment_table.getColumns().get(6);
        column3.setCellValueFactory(new PropertyValueFactory("lastUpdate"));

    }
}