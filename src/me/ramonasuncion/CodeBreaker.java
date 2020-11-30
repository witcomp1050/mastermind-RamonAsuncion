package me.ramonasuncion;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

public class CodeBreaker {
    //Make a guess class
    public void scoreGuess()
    {
        //<editor-fold desc="...">
        Button submitGuess = new Button("Submit Guess");
        submitGuess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (index > 0 && index <= 10) // Subject to change just makes sure that there is 10 rows 
                {
                    System.out.println("Debug: Sumbit Guess clicked");
                    createCircle();
                }
                else
                {
                    playAgain(false);
                }
            }
        });

        // Size for guess button
        submitGuess.setPrefHeight(50.0);
        submitGuess.setPrefWidth(120.0);
        setTopAnchor(submitGuess, 25.0);
        setLeftAnchor(submitGuess, 560.0);
        //</editor-fold>
    }

    public void colorChange(int element, Shape shape)
    {
        //<editor-fold desc="...">
        switch(numbers[element]){
            case 0:
                shape.setFill(Color.BLUE);
                break;
            case 1:
                shape.setFill(Color.GREEN);
                break;
            case 2:
                shape.setFill(Color.ORANGE);
                break;
            case 3:
                shape.setFill(Color.PURPLE);
                break;
            case 4:
                shape.setFill(Color.RED);
                break;
            case 5:
                shape.setFill(Color.YELLOW);
                break;
        }
        //</editor-fold>
    }


    private void createCircle()
    {
        //<editor-fold desc="...">

        HBox guessing = new HBox();
        guessing.setSpacing(25);


        for(int i = 0; i < 4; i++)
        {
            Circle createCircle = new Circle(15);
            guessing.getChildren().add(createCircle);
            colorChange(i, createCircle);
        }

        // Seperate vertically
        Separator seperate = new Separator();
        seperate.setOrientation(Orientation.VERTICAL);
        guessing.getChildren().add(seperate);

        numbers = new int[] {0, 0, 0, 0};
        int[] feedbackPegs = codemaker.scoreGuess(numbers, code);

        for(int i = 0; i < 4; i++) // The 4 is the code length.
        {
            Circle feedbackCircles = new Circle(25);
            // Checks if there is a value in the element ands fills for black pegs.

            if(feedbackPegs[0] > 0)
            {
                feedbackCircles.setFill(Color.BLACK);
                feedbackPegs[0]--;
            }
            // Checks if there is a value in the element ands fills for white pegs.
            else if(feedbackPegs[1] > 0)
            {
                feedbackCircles.setFill(Color.WHITE);
                feedbackPegs[1]--;
            }

        }

        // Win the Game
        if (feedbackPegs[0] == 4){
            playAgain(true);
        }
        //</editor-fold>
    }

    public void playAgain(boolean win)
    {
    }


    // Member variables
    int index;
    CodeMaker codemaker;
    int[] code;
    int[] numbers;
}
