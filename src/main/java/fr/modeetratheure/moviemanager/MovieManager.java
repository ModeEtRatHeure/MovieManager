package fr.modeetratheure.moviemanager;

import fr.modeetratheure.moviemanager.display.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieManager extends Application {

    SceneManager sceneManager;

    @Override
    public void start(Stage stage) throws IOException {
        this.sceneManager = new SceneManager(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}