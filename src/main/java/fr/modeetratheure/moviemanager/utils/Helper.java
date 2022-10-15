package fr.modeetratheure.moviemanager.utils;

import fr.modeetratheure.moviemanager.exceptions.InvalidPathException;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

public class Helper {

    private static File appFolder;
    private static File logsFolder;
    private static File moviesFolder;

    public static void init(){
        generateParentFolder();
        try{
            generateAppFolders();
        }catch(IOException e){

        }
    }

    private static void generateParentFolder(){
        String os = System.getProperty("os.name");

        if(os.contains("windows")){
            appFolder = new File(System.getenv("AppData") + File.separator + "MovieManager");
        }else{
            appFolder = new File(System.getenv("home") + File.separator + "MovieManager");
        }
    }

    private static void generateParentFolder(String path) throws InvalidPathException {
        File validTest = new File(path);
        if(validTest.isDirectory()){
            appFolder = validTest;
        }else{
            throw new InvalidPathException();
        }
    }

    static void generateAppFolders() throws IOException {
        logsFolder = new File(appFolder.getPath() + File.separator + "logs");
        moviesFolder = new File(appFolder.getPath() + File.separator + "movies");

        if(!appFolder.exists()){
            if(!appFolder.mkdir()){
                throw new IOException();
            }
            if(!logsFolder.exists()){
                if(!logsFolder.mkdir()){
                    throw new IOException();
                }
            }
            if(!moviesFolder.exists()){
                if(!moviesFolder.mkdir()){
                    throw new IOException();
                }
            }
        }
    }

    public static File getAppFolder(){
        return appFolder;
    }

    public static File getLogsFolder(){
        return logsFolder;
    }

    public static File getMoviesFolder(){
        return moviesFolder;
    }
}
