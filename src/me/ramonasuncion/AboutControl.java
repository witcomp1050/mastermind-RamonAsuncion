package me.ramonasuncion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutControl
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

    // Casting button Stage exit out
    private void exitAboutScene(){
        Stage stage = (Stage)btnExit.getScene().getWindow();
        stage.close();
    }
}
