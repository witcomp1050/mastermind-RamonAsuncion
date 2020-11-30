package me.ramonasuncion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("mmind.fxml"));
        Parent root =  loader.load();


        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
//        CodeMaker make = new CodeMaker();
//
//        int[] nums = new int[] {-1, -1, -1, -1};
//        int[] randomCode = make.codeConverstionToIntegers(make.makeRandomCode());
//        int[] feedback = make.scoreGuess(nums, randomCode);
//        /*
//        Now, feedback[0] = number of black pegs
//        feedback[1] = number of white pegs
//          */
//
//        if (feedback[0]==4) { //if player has won
//            System.out.print("WIN!");
//        }
//
//        if(feedback[0] > 0){
//            System.out.println("Hello");
//            feedback[0]--;
//        }
//        if(feedback[1] > 0){
//            System.out.println("World");
//            feedback[1]--;
//        }

        launch(args);
    }
}


