package me.ramonasuncion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
hj
    @Override
    public void start(Stage primaryStage) throws Exception
    {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        Parent root =  loader.load();


        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        CodeMaker solution = new CodeMaker();
        System.out.println("The solution is: " + solution.randomColorCombination());
        launch(args);

    }
}
