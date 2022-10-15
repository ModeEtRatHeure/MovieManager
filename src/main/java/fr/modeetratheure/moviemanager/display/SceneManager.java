package fr.modeetratheure.moviemanager.display;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    static Stage stage;

    public static void init(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setTitle("MovieManager");
        stage.show();
        stage.centerOnScreen();
    }

    public static void setScene(Scenes scene) {
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getClassLoader().getResource(scene.getName()));
        try {
            stage.setScene(new Scene(loader.load(), scene.getWidth(), scene.getHeight()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
