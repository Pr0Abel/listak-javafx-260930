package com.example.listak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    private ListView<String> lv_lista1;
    @FXML
    private ImageView iv_add;
    @FXML
    private ImageView iv_del;
    @FXML
    private ImageView iv_kuka2;
    @FXML
    private ListView<String> lv_lista2;
    @FXML
    private Label l_osszes;
    @FXML
    private ImageView iv_save;

    int lista1Db = 0;
    int lista2Db = 0;
    int index = -1;
    Object seleted;

    @FXML
    public void initialize() {
        File file = new File("listak.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String sor;
                boolean balLista = true;
                while ((sor = reader.readLine()) != null) {
                    if (sor.isEmpty()) {
                        balLista = false;
                        continue;
                    }

                    if (balLista) {
                        lv_lista1.getItems().add(sor);
                        lista1Db++;
                    } else {
                        lv_lista2.getItems().add(sor);
                        lista2Db++;
                    }
                }
                frissitOsszesLabel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void frissitOsszesLabel() {
        l_osszes.setText(lista1Db + " / " + lista2Db + " elem van a listákban");
    }

    @FXML
    public void onKittyClick(MouseEvent event) {
        lv_lista1.getItems().add("Kitty");
        lista1Db++;
        frissitOsszesLabel();
    }

    @FXML
    public void onGombaClick(MouseEvent event) {
        lv_lista1.getItems().add("Gomba");
        lista1Db++;
        frissitOsszesLabel();
    }

    @FXML
    public void onMadarClick(MouseEvent event) {
        lv_lista1.getItems().add("Madár");
        lista1Db++;
        frissitOsszesLabel();
    }

    @FXML
    public void onKuka1Click(MouseEvent event) {
        lv_lista1.getItems().clear();
        lista1Db = 0;
        frissitOsszesLabel();
    }

    @FXML
    public void onKuka2Click(MouseEvent event) {
        lv_lista2.getItems().clear();
        lista2Db = 0;
        frissitOsszesLabel();
    }

    @FXML
    public void onAddClick(MouseEvent event) {
        seleted = lv_lista1.getSelectionModel().getSelectedItem();
        if (seleted != null) {
            lv_lista2.getItems().add(seleted.toString());
            lista2Db++;
            frissitOsszesLabel();
        }
    }

    @FXML
    public void onDelClick(MouseEvent event) {
        index = lv_lista2.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            lv_lista2.getItems().remove(index);
            lista2Db--;
            frissitOsszesLabel();
        }
    }

    @FXML
    public void onSaveClick(MouseEvent event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("listak.txt"))) {
            for (Object item : lv_lista1.getItems()) {
                writer.write(item.toString());
                writer.newLine();
            }

            writer.newLine();
            for (Object item : lv_lista2.getItems()) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}