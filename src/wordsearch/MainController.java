package wordsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileNotFoundException;
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
            System.out.println("problem importing word file...");
        }

    }

    public void clickStartButton(ActionEvent event) {
        System.out.println("Word Search will display in GUI later...");

        readWordFile();


    }

    public void clickExitButton(ActionEvent event) {
        System.out.println("Word Search will exit when clicked...");
        System.exit(0);
    }

}