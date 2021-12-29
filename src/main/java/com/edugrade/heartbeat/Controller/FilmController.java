package com.edugrade.heartbeat.Controller;


import com.edugrade.heartbeat.DAO.FilmDAO;
import com.edugrade.heartbeat.Model.FilmEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Byte.*;


public class FilmController implements Initializable {



    @FXML
    private TableView <FilmEntity> film_table;



    @FXML
    private Button show_all_films;
    @FXML
    private Button search_button;
    @FXML
    private Button delete_button;
    @FXML
    private Button clear_button;
    @FXML
    private Button update_button;
    @FXML
    private Button create_new_film_button;

    @FXML
    private TextField tf_search;
    @FXML
    private TextField tf_filmid;
    @FXML
     private TextField tf_title;
    @FXML
    private TextArea tf_description;
    @FXML
    private TextField tf_rentalduration;
    @FXML
    private TextField tf_rentalrate;
    @FXML
    private TextField tf_replacementcost;
    @FXML
    private TextField tf_releaseyear;
    @FXML
    private TextField tf_languageid;
    @FXML
    private TextField tf_length;

    private final FilmDAO filmDAO = new FilmDAO();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
       show_all_films.setOnAction(event -> showAllFilms() );
       clear_button.setOnAction(event -> clearSelectedFields());
       selectFromTable();
       create_new_film_button.setOnAction(event -> addNewMovie());
       update_button.setOnAction(event -> updateEntryFilm());
       delete_button.setOnAction(event -> deleteSelectedFilm());
    }




    private void showAllFilms(){
        ObservableList<FilmEntity> filmEntityObservableList = filmDAO.getAll();
        tableResult(filmEntityObservableList);
    }


    private void clearSelectedFields() {
        if (tf_title != null) {
            tf_title.setText("");
            tf_description.setText("");
            tf_rentalduration.setText("");
            tf_rentalrate.setText("");
            tf_replacementcost.setText("");
            tf_languageid.setText("");
            tf_length.setText("");
            tf_releaseyear.setText("");
            tf_filmid.setText("");
        }

    }

    private void addNewMovie() {
        filmDAO.addNewFilm(
                tf_title.getText(),
                tf_description.getText(),
                Byte.parseByte(tf_languageid.getText()),
                Short.valueOf(tf_releaseyear.getText()),
                Byte.parseByte(String.valueOf(tf_rentalduration.getText())),
                Double.parseDouble(tf_rentalrate.getText()),
                Short.parseShort(tf_length.getText()),
                Double.parseDouble(tf_replacementcost.getText())

          );
    }


    private void updateEntryFilm() {
        filmDAO.updateFilm(
                Short.parseShort(tf_filmid.getText()),
                tf_title.getText(),
                tf_description.getText(),
                Short.valueOf(tf_releaseyear.getText()),
                parseByte(tf_languageid.getText()),
                parseByte(tf_rentalduration.getText()),
                Double.parseDouble(tf_rentalrate.getText()),
                Short.parseShort(tf_length.getText()),
                Double.parseDouble(tf_replacementcost.getText())
        );
    }




        public void selectFromTable() {
            TableView.TableViewSelectionModel<FilmEntity> selectionModel = film_table.getSelectionModel();
            selectionModel.setSelectionMode(SelectionMode.SINGLE);
            ObservableList<FilmEntity> selectedItems = selectionModel.getSelectedItems();
            film_table.setOnMouseClicked(MouseEvent -> selectedItems.forEach(f -> {
                        tf_title.setText(f.getTitle());
                        tf_description.setText(f.getDescription());
                        tf_releaseyear.setText(String.valueOf(f.getReleaseYear()));
                        tf_languageid.setText(String.valueOf(f.getLanguageId()));
                        tf_rentalduration.setText(f.getRentalDuration());
                        tf_rentalrate.setText(String.valueOf(f.getRentalRate()));
                        tf_length.setText(String.valueOf(f.getLength()));
                        tf_replacementcost.setText(String.valueOf(f.getReplacementCost()));
                        tf_filmid.setText(String.valueOf(f.getFilmId()));
            }));

        }

    private void deleteSelectedFilm() {
        filmDAO.deleteEntryById(Short.parseShort(tf_filmid.getText()));
    }






        private void tableResult(ObservableList<FilmEntity> filmEntityObservableList) {
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








