package de.thunderfrog.main;

import de.thunderfrog.App;
import de.thunderfrog.utils.PropertiesLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Properties;

public class MainController {

    public TextField txtPath;
    public Button btnScan;
    public ListView<String> lstFolders;
    public Button btnCreateList;
    public Button btnAbout;
    public Label txtFolderCount;
    public Label txtStatus;
    public static ArrayList<String> Folders = new ArrayList<>();
    private Properties prop;

    public MainController() {
        this.prop = PropertiesLoader.loadPropertie();
    }

    @FXML
    private void ScanFolders() {
        lstFolders.getItems().clear();
        txtFolderCount.setText("0");
        Folders.clear();
        try {
            Files.list(new File(txtPath.getText()).toPath())
                    .forEach(path -> {
                        lstFolders.getItems().add(path.toString());
                        Folders.add(path.toString());
                        txtStatus.setTextFill(Color.web(prop.getProperty("colorOK")));
                        txtStatus.setText("Scanning...");
                    });
            txtStatus.setTextFill(Color.web(prop.getProperty("colorOK")));
            txtStatus.setText("Scan completed");
            txtFolderCount.setText(String.valueOf(Folders.size()));
        } catch (IOException ex) {
            ex.printStackTrace();
            txtStatus.setTextFill(Color.web(prop.getProperty("colorBAD")));
            txtStatus.setText("ERROR");
        }
    }

    @FXML
    private void CreateList(){
        JFrame DialogFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();

        FileFilter txtFilter = new FileTypeFilter(".txt", "Text Document");
        fileChooser.addChoosableFileFilter(txtFilter);

        fileChooser.setAcceptAllFileFilterUsed(false);

        fileChooser.setDialogTitle("Save dir2list File");

        int userSelection = fileChooser.showSaveDialog(DialogFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File Filename = fileChooser.getSelectedFile();
                FileWriter FolderWriter = new FileWriter(Filename.getAbsolutePath() + ".txt");
                // File Header
                FolderWriter.write("dir2list Folders\n\n");
                // Write Array to File
                for (String folder : Folders) {
                    FolderWriter.write(folder + "\n");
                }
                // FileWrite Close
                FolderWriter.close();
                txtStatus.setTextFill(Color.web("#1bab22"));
                txtStatus.setText("File created");
            } catch (IOException ex) {
                ex.printStackTrace();
                txtStatus.setTextFill(Color.web(prop.getProperty("colorBAD")));
                txtStatus.setText("ERROR");
            }
        }
    }

    @FXML
    private void showAbout() throws IOException {
        App.setRoot("about");
    }


    /**
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    **/
}
