package me.ramonasuncion;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

public class CodeBreaker {
    
    public void choosePeg()
    {
        HBox guessOptions = new HBox();
        guessOptions.setSpacing(25);

        for(int i = 0; i < 4; i++)
        {
            Circle createCircle = new Circle(15);
            guessOptions.getChildren().add(createCircle);
            int finalI = i;
            createCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    colorToggleOnClick(finalI, createCircle);
                }
            });
        }
    }

    public void playAgain(boolean won)
    {

    }
    //Make a guess class
    public void scoreGuess()
    {
        //<editor-fold desc="...">
        Button submitGuess = new Button("Submit Guess");
        submitGuess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
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

    public void colorToggleOnClick(int element, Circle circle)
    {
        //<editor-fold desc="...">
        if (numbers[element] == 5){ numbers[element] = 1; }
        else { numbers[element]++;} // Adds count if element does not represent 6 colors
        colorChange(element, circle);
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

        int[] feedbackPegs = codeCreator.scoreGuess(numbers, randomGeneratedCode);

        for(int i = 0; i < 4; i++) // The 4 is the codeLength.
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

        // Win the Game by having 4 black pegs
        if (feedbackPegs[0] == 4)
        {
            playAgain(true);
        }
        //</editor-fold>
    }

    public CodeBreaker()
    {
        //<editor-fold desc="...">
        numbers = new int[] {0, 0, 0, 0};
        codeCreator = new CodeMaker();
        randomGeneratedCode = codeCreator.covertToIntegers(codeCreator.makeRandomCode());
        //</editor-fold>
    }

    // Member variables
    int index;
    CodeMaker codeCreator;
    int[] randomGeneratedCode;
    int[] numbers;
}
