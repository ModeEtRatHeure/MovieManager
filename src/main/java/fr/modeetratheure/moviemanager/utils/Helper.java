package fr.modeetratheure.moviemanager.utils;

import fr.modeetratheure.moviemanager.display.SceneManager;
import fr.modeetratheure.moviemanager.display.Scenes;

import java.io.*;
import java.nio.file.Files;

public class Helper {

    private static File appFolder;
    private static File logsFolder;
    private static File moviesDataFolder;
    private static File moviesPath;

    public static void init() throws IOException {
        generateParentFolder();
        generateAppFolders();
        generateAppFiles();
    }

    private static void generateAppFiles() throws IOException {
        moviesPath = new File(appFolder.getPath() + File.separator + "moviesPath.txt");
        moviesPath.createNewFile();
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

    public static boolean registerMoviesFolder(String path) throws IOException {
        if(new File(path).isDirectory()){
            write(moviesPath, path);
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
    public static boolean isMoviesFolderRegistered() throws IOException {
        File path = new File(read(moviesPath));
        return path.isDirectory() && path.exists();
    }

    static void write(File file, String text) throws IOException {
        try(FileWriter writer = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(writer);){
            bw.write(text);
        }
    }

    static String read(File file) {
        try(FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader);){
            String path = br.readLine();
            return path == null ? "nullstr" : path;
        } catch (IOException e) {
            return "";
        }
    }
}
