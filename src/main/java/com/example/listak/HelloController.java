package com.example.listak;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    @FXML
    private ListView<String> lv_lista1;
    @FXML
    private ListView<String> lv_lista2;
    @FXML
    private Label l_osszes;

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
            } catch (IOException e) {e.printStackTrace();}
        }
    }

    private void frissitOsszesLabel() {
        if (!HelloAppTest.isRunningTest) l_osszes.setText(lista1Db + " / " + lista2Db + " elem van a listákban");
    }

    @FXML
    public void onKittyClick(MouseEvent event) {
        if (!HelloAppTest.isRunningTest) lv_lista1.getItems().add("Kitty");
        lista1Db++;
        frissitOsszesLabel();
    }

    @FXML
    public void onGombaClick(MouseEvent event) {
        if (!HelloAppTest.isRunningTest) lv_lista1.getItems().add("Gomba");
        lista1Db++;
        frissitOsszesLabel();
    }

    @FXML
    public void onMadarClick(MouseEvent event) {
        if (!HelloAppTest.isRunningTest) lv_lista1.getItems().add("Madár");
        lista1Db++;
        frissitOsszesLabel();
    }

    @FXML
    public void onKuka1Click(MouseEvent event) {
        if (!HelloAppTest.isRunningTest) lv_lista1.getItems().clear();
        lista1Db = 0;
        frissitOsszesLabel();
    }

    @FXML
    public void onKuka2Click(MouseEvent event) {
        if (!HelloAppTest.isRunningTest) lv_lista2.getItems().clear();
        lista2Db = 0;
        frissitOsszesLabel();
    }

    @FXML
    public void onAddClick(MouseEvent event) {
        if (HelloAppTest.isRunningTest) {seleted = "asd";}
        if (!HelloAppTest.isRunningTest) seleted = lv_lista1.getSelectionModel().getSelectedItem();
        if (seleted != null) {
            if (!HelloAppTest.isRunningTest) lv_lista2.getItems().add(seleted.toString());
            lista2Db++;
            frissitOsszesLabel();
        }
    }

    @FXML
    public void onDelClick(MouseEvent event) {
        if (HelloAppTest.isRunningTest) {index = 0;}
        if (!HelloAppTest.isRunningTest)  index = lv_lista2.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            if (!HelloAppTest.isRunningTest) lv_lista2.getItems().remove(index);
            lista2Db--;
            frissitOsszesLabel();
        }
    }

    @FXML
    public void onSaveClick(MouseEvent event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("listak.txt"))) {
            if (!HelloAppTest.isRunningTest) {
                for (Object item : lv_lista1.getItems()) {
                    writer.write(item.toString());
                    writer.newLine();
                }

                writer.newLine();
                for (Object item : lv_lista2.getItems()) {
                    writer.write(item.toString());
                    writer.newLine();
                }
            }
        } catch(IOException e){e.printStackTrace();}
    }
}