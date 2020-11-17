package wordsearch;

import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {

    // Might be needed for future improvements.
    //@FXML
    //private GridPane gpInterface;

    public MenuController() {

    }

    public void clickStartButton(ActionEvent event) {
        System.out.println("Welcome to a Word Search game!!");

        try {
            FXMLLoader boardFXMLLoader = new FXMLLoader();
            Parent board = boardFXMLLoader.load(getClass().getResource("BoardInterface.fxml"));

            Scene newBoard = new Scene(board);

            Stage boardStage = new Stage();

            boardStage.setTitle("Letter Board");
            boardStage.setScene(newBoard);

            boardStage.setX(500);
            boardStage.setY(20);
            boardStage.show();
        } catch (IOException e) {
            System.out.println("Window load failed.");
            System.exit(0);
        }

    }

    public void clickExitButton(ActionEvent event) {
        System.out.println("Thanks for playing! Goodbye!");
        System.exit(0);
    }

}