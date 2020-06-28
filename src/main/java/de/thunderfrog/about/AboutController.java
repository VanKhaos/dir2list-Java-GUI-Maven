package de.thunderfrog.about;

import de.thunderfrog.App;
import de.thunderfrog.utils.PropertiesLoader;
import de.thunderfrog.utils.OpenWebpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class AboutController {

    public Button btnBackMain;
    private Properties prop;
    public Label labelVersion;
    public Hyperlink hyperlinkGit;
    public Hyperlink hyperlinkLicense;

    public AboutController() {this.prop = PropertiesLoader.loadPropertie();}

    @FXML
    public void initialize() {
        labelVersion.setText(prop.getProperty("version"));
    }

    @FXML
    public void switchToMain() throws IOException {
        App.setRoot("main");
    }

    public void gotoGit(ActionEvent actionEvent) {
        OpenWebpage.gotoPage(prop.getProperty("gitURL"));
    }

    public void showLicense(ActionEvent actionEvent) {
        OpenWebpage.gotoPage(prop.getProperty("gnuURL"));
    }
}
