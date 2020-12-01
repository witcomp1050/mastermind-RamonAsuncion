package me.ramonasuncion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application
{

    @FXML
    Button buttonMANA;


    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        (new CodeBreaker()).initalizeCodeBreaker();

        Menu file = new Menu("File");

        MenuItem config = new MenuItem("Configuration");
        MenuItem exit = new MenuItem("Exit");

        file.getItems().addAll(config, exit);

        Menu other = new Menu("Other");
        MenuItem about = new MenuItem("About");


        other.getItems().addAll(about);

        MenuBar menuBar = new MenuBar();

        menuBar.setTranslateX(200);
        menuBar.setTranslateY(20);

        menuBar.getMenus().addAll(file, other);


        Group root = new Group(menuBar);
        Scene scene = new Scene(root, 595, 200, Color.BEIGE);


        primaryStage.setTitle("Menu Bar Example");
        primaryStage.setScene(scene);
        primaryStage.show();




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


