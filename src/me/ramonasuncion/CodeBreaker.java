package me.ramonasuncion;

//<editor-fold desc="imports">
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;
//</editor-fold>


public class CodeBreaker {


    public void playAgain(boolean winTheGame, Stage stag)
    {
        //<editor-fold desc="...">
        Stage stage = new Stage();
        stage.setResizable(false);
        AnchorPane play = new AnchorPane();
        Scene scene = new Scene(play, 300, 100);
        stage.setResizable(false);

        Label paragraph = new Label();
        setTopAnchor(paragraph, 10.0);
        setLeftAnchor(paragraph, 40.0);


        if(winTheGame)
        {
            stage.setTitle("Mastermind: You have won!");
            paragraph.setText("Thank you for playing. " +
                    "You have won!");
        }
        else
        {
            stage.setTitle("Mastermind: You lost!");
            paragraph.setText("Thank you for playing. " +
                    "Better luck next time");
        }

        Button again = new Button("Play");
        setTopAnchor(again, 50.0);
        setLeftAnchor(again, 50.0);
        again.setPrefHeight(20.0);
        again.setPrefWidth(90.0);

        again.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                stage.close();
                stag.close();
                (new CodeBreaker()).initalizeCodeBreaker();
            }});

        Button leave = new Button("Exit");
        setTopAnchor(leave, 50.0);
        setLeftAnchor(leave, 180.0);
        leave.setPrefHeight(20.0);
        leave.setPrefWidth(90.0);


        leave.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) { System.exit(0); }
          });


        play.getChildren().addAll(paragraph, again, leave);

        stage.setScene(scene);
        stage.show();
        //</editor-fold>
    }

    public void colorChange(int element, Shape shape)
    {
        //<editor-fold desc="...">
        switch(numbers[element]){
            case 0:
                shape.setFill(Color.BLACK); // Blank
                break;
            case 1:
                shape.setFill(Color.BLUE);
                break;
            case 2:
                shape.setFill(Color.GREEN);
                break;
            case 3:
                shape.setFill(Color.ORANGE);
                break;
            case 4:
                shape.setFill(Color.PURPLE);
                break;
            case 5:
                shape.setFill(Color.RED);
                break;
            case 6:
                shape.setFill(Color.YELLOW); // Blank
                break;
        }
        //</editor-fold>
    }

    public void colorToggleOnClick(int element, Circle circle)
    {
        //<editor-fold desc="...">
        if (numbers[element] == 6){ numbers[element] = 0; } // Cycle through the 6 colors.
        else { numbers[element]++;} // Adds count if element does not represent 6 colors
        colorChange(element, circle);
        //</editor-fold>
    }

    private void createCircle(AnchorPane game, Stage stage)
    {
        //<editor-fold desc="...">
        HBox feedback = new HBox();
        feedback.setSpacing(30.0);

        element--; // Used for positioning

        for(int i = 0; i < 4; i++)
        {
            Circle createCircle = new Circle(18.0);
            feedback.getChildren().add(createCircle);
            colorChange(i, createCircle);
        }

        // Seperator that goes HORIZONTAL
        Separator seperate = new Separator();
        seperate.setOrientation(Orientation.HORIZONTAL);
        feedback.getChildren().add(seperate);

        int[] feedbackPegs = codeCreator.scoreGuess(numbers, randomGeneratedCode);

        if (feedbackPegs[0] == 4) { playAgain(true, stage); }  // Win the Game by having 4 black pegs

        for(int i = 0; i < 4; i++) // The 4 is the codeLength by default.
        {
            Circle feedbackCircles = new Circle(15.0); // Feedback circles

            feedback.getChildren().add(feedbackCircles);
            // Checks if there is a value in the element ands fills for black pegs.

            if(feedbackPegs[0] > 0)
            {
                feedbackCircles.setFill(Color.BLACK); // Correct position + Correct Color
                feedbackPegs[0]--;
            }
            // Checks if there is a value in the element ands fills for white pegs.
            else if(feedbackPegs[1] > 0)
            {
                feedbackCircles.setFill(Color.WHITE); // Wrong position + Correct Color
                feedbackPegs[1]--;
            }
            else
            {
                feedbackCircles.setFill(Color.TRANSPARENT); // Wrong position + Wrong Color
                feedbackPegs[1]--;
            }
        }

        // Starts from the bottom due to element--; and with the element value then continues to space it out.
        setTopAnchor(feedback, element * 60.0);
        setLeftAnchor(feedback, 305.0);

        game.getChildren().add(feedback); // Get child component
        //</editor-fold>
    }


    public void initalizeCodeBreaker()
    {
        //<editor-fold desc="...">

        AnchorPane game = new AnchorPane();
        Stage stage = new Stage();

        stage.setTitle("Mastermind");
        Scene scene = new Scene(game, 1000, 720);
        stage.setResizable(false);


        // Menu Bar
        MenuBar menuBar = new MenuBar();
        VBox vBox = new VBox(menuBar);

        Menu menu = new Menu("File");

        MenuItem configGameMenuItem = new MenuItem("Configuration");
        MenuItem exitMenuItem = new MenuItem("Exit");

        menu.getItems().add(configGameMenuItem);
        menu.getItems().add(exitMenuItem);

        menuBar.getMenus().add(menu);

        Menu menu1 = new Menu("Other");

        MenuItem aboutMenuItem = new MenuItem("About");

        menu1.getItems().add(aboutMenuItem);

        menuBar.getMenus().add(menu1);

        // Scene scene = new Scene(vBox, 960, 600);







        HBox guessOptions = new HBox();
        guessOptions.setSpacing(30.0);

        for(int i = 0; i < 4; i++)
        {
            Circle createCircle = new Circle(23.0);
            guessOptions.getChildren().add(createCircle);
            int tempI = i;
            createCircle.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    colorToggleOnClick(tempI, createCircle);
                }
            });
            setTopAnchor(guessOptions, 25.0);
            setLeftAnchor(guessOptions, 280.0);
        }

        Button submitGuess = new Button("Submit Guess");
        submitGuess.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                numberofRows++;
                if (numberofRows > 0 && numberofRows <= 10) // the 10 is the number of rows
                {
                    createCircle(game, stage);
                }
                else{
                    playAgain(false, stage);
                }
            }
        });

        // Size for submit button
        submitGuess.setPrefHeight(50.0);
        submitGuess.setPrefWidth(100.0);
        setTopAnchor(submitGuess, 20.0);
        setLeftAnchor(submitGuess, 150.0);

        game.getChildren().addAll(guessOptions, submitGuess);

        stage.setScene(scene);
        stage.show();
        //</editor-fold>
    }

    public CodeBreaker()
    {
        //<editor-fold desc="...">
        numbers = new int[] {-1, -1, -1, -1}; // This is to get the default color of black (blank)
        codeCreator = new CodeMaker();
        randomGeneratedCode = codeCreator.covertToIntegers(codeCreator.makeRandomCode());
        numberofRows = 0;
        element = 12; // Element spacing
        //</editor-fold>
    }

    // Member variables
    //<editor-fold desc="...">
    int element;
    int numberofRows;
    CodeMaker codeCreator;
    int[] randomGeneratedCode;
    int[] numbers;
    //</editor-fold>
}
