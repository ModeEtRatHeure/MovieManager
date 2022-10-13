module fr.modeetratheure.moviemanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.modeetratheure.moviemanager to javafx.fxml;
    exports fr.modeetratheure.moviemanager;
    exports fr.modeetratheure.moviemanager.controllers to javafx.fxml;
    opens fr.modeetratheure.moviemanager.controllers to javafx.fxml;
}