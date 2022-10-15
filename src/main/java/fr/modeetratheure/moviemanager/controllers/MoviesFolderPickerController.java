package fr.modeetratheure.moviemanager.controllers;

import fr.modeetratheure.moviemanager.utils.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class MoviesFolderPickerController {

    @FXML
    TextField entry;
    @FXML
    Label test;
    @FXML
    Button browseButton;
    @FXML
    Label errorPlaceholder;

    @FXML
    public void initialize(){
        System.out.println(test.getText());
        entry.setOnAction((e) -> {
            if(!Helper.registerMoviesFolder(entry.getText())){
                errorPlaceholder.setText("Erreur: chemin invalide");
            }
        });
        browseButton.setOnAction((e) -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Choose your movies folder");
            entry.setText(directoryChooser.showDialog(null).getPath());
        });
    }
}
