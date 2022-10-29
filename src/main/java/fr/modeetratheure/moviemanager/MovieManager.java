package fr.modeetratheure.moviemanager;

import fr.modeetratheure.moviemanager.display.SceneManager;
import fr.modeetratheure.moviemanager.utils.Helper;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieManager extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Helper.init();
        SceneManager.init(stage);
    }
}