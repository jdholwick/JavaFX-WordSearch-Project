package wordsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {

    @FXML
    private Label lbl_1_1, lbl_2_1, lbl_3_1, lbl_4_1, lbl_5_1, lbl_6_1, lbl_7_1, lbl_8_1, lbl_9_1, lbl_10_1, lbl_11_1, lbl_12_1, lbl_13_1, lbl_14_1, lbl_15_1;
    @FXML
    private Label lbl_1_2, lbl_2_2, lbl_3_2, lbl_4_2, lbl_5_2, lbl_6_2, lbl_7_2, lbl_8_2, lbl_9_2, lbl_10_2, lbl_11_2, lbl_12_2, lbl_13_2, lbl_14_2, lbl_15_2;
    @FXML
    private Label lbl_1_3, lbl_2_3, lbl_3_3, lbl_4_3, lbl_5_3, lbl_6_3, lbl_7_3, lbl_8_3, lbl_9_3, lbl_10_3, lbl_11_3, lbl_12_3, lbl_13_3, lbl_14_3, lbl_15_3;
    @FXML
    private Label lbl_1_4, lbl_2_4, lbl_3_4, lbl_4_4, lbl_5_4, lbl_6_4, lbl_7_4, lbl_8_4, lbl_9_4, lbl_10_4, lbl_11_4, lbl_12_4, lbl_13_4, lbl_14_4, lbl_15_4;
    @FXML
    private Label lbl_1_5, lbl_2_5, lbl_3_5, lbl_4_5, lbl_5_5, lbl_6_5, lbl_7_5, lbl_8_5, lbl_9_5, lbl_10_5, lbl_11_5, lbl_12_5, lbl_13_5, lbl_14_5, lbl_15_5;
    @FXML
    private Label lbl_1_6, lbl_2_6, lbl_3_6, lbl_4_6, lbl_5_6, lbl_6_6, lbl_7_6, lbl_8_6, lbl_9_6, lbl_10_6, lbl_11_6, lbl_12_6, lbl_13_6, lbl_14_6, lbl_15_6;
    @FXML
    private Label lbl_1_7, lbl_2_7, lbl_3_7, lbl_4_7, lbl_5_7, lbl_6_7, lbl_7_7, lbl_8_7, lbl_9_7, lbl_10_7, lbl_11_7, lbl_12_7, lbl_13_7, lbl_14_7, lbl_15_7;
    @FXML
    private Label lbl_1_8, lbl_2_8, lbl_3_8, lbl_4_8, lbl_5_8, lbl_6_8, lbl_7_8, lbl_8_8, lbl_9_8, lbl_10_8, lbl_11_8, lbl_12_8, lbl_13_8, lbl_14_8, lbl_15_8;
    @FXML
    private Label lbl_1_9, lbl_2_9, lbl_3_9, lbl_4_9, lbl_5_9, lbl_6_9, lbl_7_9, lbl_8_9, lbl_9_9, lbl_10_9, lbl_11_9, lbl_12_9, lbl_13_9, lbl_14_9, lbl_15_9;
    @FXML
    private Label lbl_1_10, lbl_2_10, lbl_3_10, lbl_4_10, lbl_5_10, lbl_6_10, lbl_7_10, lbl_8_10, lbl_9_10, lbl_10_10, lbl_11_10, lbl_12_10, lbl_13_10, lbl_14_10, lbl_15_10;
    @FXML
    private Label lbl_1_11, lbl_2_11, lbl_3_11, lbl_4_11, lbl_5_11, lbl_6_11, lbl_7_11, lbl_8_11, lbl_9_11, lbl_10_11, lbl_11_11, lbl_12_11, lbl_13_11, lbl_14_11, lbl_15_11;
    @FXML
    private Label lbl_1_12, lbl_2_12, lbl_3_12, lbl_4_12, lbl_5_12, lbl_6_12, lbl_7_12, lbl_8_12, lbl_9_12, lbl_10_12, lbl_11_12, lbl_12_12, lbl_13_12, lbl_14_12, lbl_15_12;
    @FXML
    private Label lbl_1_13, lbl_2_13, lbl_3_13, lbl_4_13, lbl_5_13, lbl_6_13, lbl_7_13, lbl_8_13, lbl_9_13, lbl_10_13, lbl_11_13, lbl_12_13, lbl_13_13, lbl_14_13, lbl_15_13;
    @FXML
    private Label lbl_1_14, lbl_2_14, lbl_3_14, lbl_4_14, lbl_5_14, lbl_6_14, lbl_7_14, lbl_8_14, lbl_9_14, lbl_10_14, lbl_11_14, lbl_12_14, lbl_13_14, lbl_14_14, lbl_15_14;
    @FXML
    private Label lbl_1_15, lbl_2_15, lbl_3_15, lbl_4_15, lbl_5_15, lbl_6_15, lbl_7_15, lbl_8_15, lbl_9_15, lbl_10_15, lbl_11_15, lbl_12_15, lbl_13_15, lbl_14_15, lbl_15_15;

    public void readWordFile(String sWords) {

    }
    public void clickStartButton(ActionEvent event) {
        System.out.println("Word Search will display in GUI later...");

        try
        {
            File wordFile = new File("src/wordsearch/words.txt");
            Scanner sc = new Scanner(wordFile);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("problem importing word file...");
        }

        //readWordFile("words.txt");
        //String sWords = readString()
    }

    public void clickExitButton(ActionEvent event) {
        System.out.println("Word Search will exit when clicked...");
        System.exit(0);
    }

    public void changeLabel(Label curLblName, String newLabel) {
        curLblName.setText(String.valueOf(newLabel.charAt(0)));
        lbl_2_1.setText(String.valueOf(newLabel.charAt(1)));
        lbl_3_1.setText(String.valueOf(newLabel.charAt(2)));
        lbl_4_1.setText(String.valueOf(newLabel.charAt(3)));
        lbl_5_1.setText(String.valueOf(newLabel.charAt(4)));
        lbl_6_1.setText(String.valueOf(newLabel.charAt(5)));
        lbl_7_1.setText(String.valueOf(newLabel.charAt(6)));
        lbl_15_3.setText("Y");
        lbl_1_3.setText("Y");
        lbl_4_3.setText("Y");
        lbl_6_4.setText("Y");
    }

    public void onClick(MouseEvent mouseEvent) {
        changeLabel(lbl_1_1, "LOOKING");
        System.out.println("Presently just changes a column of letters to a new word when a letter label is clicked.");

    }
}