package me.ramonasuncion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application
{

    @FXML
    Button buttonMANA;


    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        (new CodeBreaker()).initalizeCodeBreaker();

       //FXMLLoader loader = new FXMLLoader(Main.class.getResource("mmind.fxml"));
       //Parent root = loader.load();

       // primaryStage.setTitle("Mastermind");
       // primaryStage.setScene(new Scene(root));
        //.setResizable(false);
       // primaryStage.show();
    }




    public void exitApp(){

    }
}


