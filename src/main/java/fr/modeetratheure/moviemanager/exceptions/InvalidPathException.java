package fr.modeetratheure.moviemanager.exceptions;

public class InvalidPathException extends Exception{

    public InvalidPathException(){
        super("Specified path does not exists");
    }

}
