package de.thunderfrog;

import de.thunderfrog.utils.PropertiesLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Properties;


public class App extends Application {

    private static Scene scene;
    private Properties prop;

    public App() {this.prop = PropertiesLoader.loadPropertie();}

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 563, 425);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(prop.getProperty("name"));
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/images/appicon.png")));
        stage.setOnCloseRequest(e -> Platform.exit());
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}