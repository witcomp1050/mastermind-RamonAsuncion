package me.ramonasuncion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
      Configuration test = new Configuration();

       (new CodeBreaker()).initalizeCodeBreaker();


    }

    int _numberOfPegs;
    int _numberOfRows;
    boolean _allowDuplicate;
    boolean _allowBlank;


}


