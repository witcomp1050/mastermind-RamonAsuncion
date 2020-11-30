package me.ramonasuncion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfigurationControl
{

    @FXML
    Button btnExit;

    // Exits out of the program
    public void initialize()
    {
        btnExit.setOnMouseClicked(e -> {
            exitAboutScene();
        });
    }

    private void exitAboutScene(){
        Stage s = (Stage)btnExit.getScene().getWindow();
        s.close();
    }
}
