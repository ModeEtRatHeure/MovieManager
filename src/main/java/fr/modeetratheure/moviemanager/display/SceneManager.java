package fr.modeetratheure.moviemanager.display;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    Stage stage;

    public SceneManager(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("MovieManager");
        this.stage.show();
        this.stage.centerOnScreen();
        setMainScene();
    }

    public void setMainScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getClassLoader().getResource("scenes/main-scene.fxml"));
        this.stage.setScene(new Scene(loader.load(), 1080, 480));
    }

}
