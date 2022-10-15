package fr.modeetratheure.moviemanager.utils;

import fr.modeetratheure.moviemanager.display.SceneManager;
import fr.modeetratheure.moviemanager.display.Scenes;

import java.io.File;
import java.io.IOException;

public class Helper {

    private static File appFolder;
    private static File logsFolder;
    private static File moviesDataFolder;
    private static File moviesFolder;

    public static void init() throws IOException {
        generateParentFolder();
        generateAppFolders();
        if(moviesFolder == null){
            SceneManager.setScene(Scenes.MOVIES_FOLDER_PICKER_SCENE);
        }else{
            SceneManager.setScene(Scenes.MAIN_SCENE);
        }
    }

    private static void generateParentFolder(){
        String os = System.getProperty("os.name").toLowerCase();

        if(os.contains("windows")){
            appFolder = new File(System.getenv("AppData") + File.separator + "MovieManager");
        }else{
            appFolder = new File(System.getenv("home") + File.separator + "MovieManager");
        }
    }

    static void generateAppFolders() throws IOException {
        logsFolder = new File(appFolder.getPath() + File.separator + "logs");
        moviesDataFolder = new File(appFolder.getPath() + File.separator + "moviesdata");

        createFolder(appFolder);
        createFolder(logsFolder);
        createFolder(moviesDataFolder);
    }

    static void createFolder(File file){
        if(!file.exists()){
            file.mkdir();
        }
    }

    public static boolean registerMoviesFolder(String path){
        File existanceTest = new File(path);
        if(existanceTest.isDirectory()){
            moviesFolder = existanceTest;
            SceneManager.setScene(Scenes.MAIN_SCENE);
            return true;
        }else{
            return false;
        }
    }

    public static File getAppFolder(){
        return appFolder;
    }

    public static File getLogsFolder(){
        return logsFolder;
    }

    public static File getMoviesDataFolder(){
        return moviesDataFolder;
    }
}
