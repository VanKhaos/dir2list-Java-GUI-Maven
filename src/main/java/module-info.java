module de.thunderfrog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens de.thunderfrog to javafx.fxml;
    opens de.thunderfrog.main to javafx.fxml;
    opens de.thunderfrog.about to javafx.fxml;

    exports de.thunderfrog;
}