package fr.modeetratheure.moviemanager.movies;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Movie {

    private VBox movieProfile;
    private ImageView imageView;
    private Label name = new Label();

    public Movie(String title){
        movieProfile = new VBox();
        imageView = new ImageView();
        name.setText(title);
        movieProfile.getChildren().addAll(imageView, name);
    }

}
