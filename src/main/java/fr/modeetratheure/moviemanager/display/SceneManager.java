package fr.modeetratheure.moviemanager.display;

import fr.modeetratheure.moviemanager.utils.Helper;
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
        boolean test = Helper.isMoviesFolderRegistered();
        setScene(!test ? Scenes.MOVIES_FOLDER_PICKER_SCENE : Scenes.MAIN_SCENE);
    }

    public static void setScene(Scenes scene) {
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getClassLoader().getResource(scene.getName()));
        try {
            if(scene.getIfDimensionsAreMaxSize()){
                stage.setResizable(false);
                stage.setScene(new Scene(loader.load()));
            }else{
                stage.setResizable(true);
                stage.setScene(new Scene(loader.load(), scene.getWidth(), scene.getHeight()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.centerOnScreen();
    }

}
