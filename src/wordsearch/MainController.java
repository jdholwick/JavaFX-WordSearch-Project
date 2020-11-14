package wordsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainController {

    @FXML
    private GridPane gpInterface;

    public void readWordFile() {

        try
        {
            File wordFile = new File("src\\wordsearch\\words.txt");
            Scanner sc = new Scanner(wordFile);

            List<String> listWords = new ArrayList<String>();

            while (sc.hasNextLine()){
                listWords.add(sc.nextLine());
            }

            System.out.println("Words that will be in the wordsearch board:");

            for (int i = 0; i < listWords.size(); i++) {
                System.out.println("   " + listWords.get(i));
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Problem importing word file...");
        }

    }

    public void clickStartButton(ActionEvent event) {
        System.out.println("Word Search will display in GUI later...");

        readWordFile();

        try {
            FXMLLoader boardFXMLLoader = new FXMLLoader();
            Parent board = boardFXMLLoader.load(getClass().getResource("Board.fxml"));

            Scene newBoard = new Scene(board);

            Stage boardStage = new Stage();

            boardStage.setTitle("Letter Board");
            boardStage.setScene(newBoard);

            boardStage.setX(20);
            boardStage.setY(20);
            boardStage.show();
        } catch (IOException e) {
            System.out.println("Window load failed.");
        }

    }

    public void clickExitButton(ActionEvent event) {
        System.out.println("Word Search will exit when clicked...");
        System.exit(0);
    }

}