package de.thunderfrog.about;

import de.thunderfrog.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class AboutController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

}