package com.edugrade.heartbeat.Controller;

import com.edugrade.heartbeat.DAO.ActorDAO;
import com.edugrade.heartbeat.Model.ActorEntity;
import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Model.FilmEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ActorController implements Initializable {

    @FXML
    private TableView actor_table;
    @FXML
    private ListView film_view;
    @FXML
    private Button update_actor_button;
    @FXML
    private  Label film_label;
    @FXML
    private Label fx_message ;
    @FXML
    private TextField tf_firstName;
    @FXML
    private TextField tf_actor_search;
    @FXML
    private TextField tf_lastName;
    @FXML
    private TextField tf_id;
    private ActorEntity actorToEditOrDelete = null;
    ActorDAO actorDAO = new ActorDAO();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectActorFromTable();
        showAllOrFilteredActors();
        update_actor_button.setOnAction(event -> updateActorRecord());

    }
    private void showAllActors(ObservableList<ActorEntity> allActors){
        actor_table.setItems(allActors);
        TableColumn column0 = (TableColumn) actor_table.getColumns().get(0);
        column0.setCellValueFactory(new PropertyValueFactory("actorId"));

        TableColumn column1 = (TableColumn) actor_table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn column2 = (TableColumn) actor_table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn column3 = (TableColumn) actor_table.getColumns().get(3);
        column3.setCellValueFactory(new PropertyValueFactory("lastUpdate"));
    }
    private void selectActorFromTable() {

        TableView.TableViewSelectionModel<ActorEntity> selectionModel = actor_table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList<ActorEntity> selectedItems = selectionModel.getSelectedItems();
        actor_table.setOnMouseClicked(MouseEvent -> selectedItems.forEach(e -> {
            actorToEditOrDelete = e;
            ObservableList<String> items =FXCollections.observableArrayList ();
            film_view.setItems(items);
            tf_firstName.setText(e.getFirstName());
            tf_lastName.setText(e.getLastName());
            film_label.setText("Aktor "+ e.getFirstName() + " Deltar i "+ e.getFilms().size()+ " följande filmer :");
            for (FilmEntity f:e.getFilms()
            ) {
                film_view.getItems().addAll(f.getTitle()+" :  "+ f.getReleaseYear());
            }



        }));


    }

    public  void showAllOrFilteredActors(){
        ObservableList<ActorEntity> actorEntityObservableList = actorDAO.getAll();

        FilteredList<ActorEntity> filteredActorList = new FilteredList<>(actorEntityObservableList, p -> true);

        tf_actor_search.textProperty().addListener((text, oldText, newText) -> {
            filteredActorList.setPredicate(actorEntity -> {
                if (newText == null || newText.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newText.toLowerCase();
                if (actorEntity.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (actorEntity.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<ActorEntity> newSortedList = new SortedList<>(filteredActorList);
        newSortedList.comparatorProperty().bind(actor_table.comparatorProperty());
        showAllActors(newSortedList);
    }
    private void updateActorRecord() {
        if(actorToEditOrDelete!=null){
            actorDAO.updateActor(
                    actorToEditOrDelete.getActorId(),
                    tf_firstName.getText(),
                    tf_lastName.getText()
            );
            showAllOrFilteredActors();
            fx_message.setText("Aktorn updaterad");
            setTimeout(() -> fx_message.setText(""), 1000);
        }

    }
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
}
