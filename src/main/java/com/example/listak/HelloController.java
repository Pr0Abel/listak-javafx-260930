package com.example.listak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private ImageView iv_kitty;
    @FXML
    private Label l_kittyDb;
    @FXML
    private ImageView iv_gomba;
    @FXML
    private Label l_gombaDb;
    @FXML
    private ImageView iv_madar;
    @FXML
    private Label l_madarDb;
    @FXML
    private ImageView iv_kuka1;
    @FXML
    private ListView lv_lista1;
    @FXML
    private ImageView iv_add;
    @FXML
    private ImageView iv_del;
    @FXML
    private ImageView iv_kuka2;
    @FXML
    private ListView lv_lista2;
    @FXML
    private Label l_osszes;
    @FXML
    private ImageView iv_save;

    int lista1Db = 0;
    int index = -1;

    @FXML
    public void initialize() {}

    @FXML
    public void onKittyClick(MouseEvent event) {
        lv_lista1.getItems().add("Kitty");
        lista1Db++;
        l_osszes.setText(lista1Db +" / 0 elem van a listákban");
    }

    @FXML
    public void onGombaClick(MouseEvent event) {
        lv_lista1.getItems().add("Gomba");
        lista1Db++;
        l_osszes.setText(lista1Db +" / 0 elem van a listákban");
    }

    @FXML
    public void onMadarClick(MouseEvent event) {
        lv_lista1.getItems().add("Madár");
        lista1Db++;
        l_osszes.setText(lista1Db +" / 0 elem van a listákban");
    }

    @FXML
    public void onKuka1Click(MouseEvent event) {
        index = lv_lista1.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            lv_lista1.getItems().remove(index);
            lista1Db--;
            l_osszes.setText(lista1Db +" / 0 elem van a listákban");
        }
    }

    @FXML
    public void onKuka2Click(MouseEvent event) {

    }

    @FXML
    public void onAddClick(MouseEvent event) {

    }

    @FXML
    public void onDelClick(MouseEvent event) {

    }

    @FXML
    public void onSaveClick(MouseEvent event) {

    }
}