package wordsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Label lbl_1_1, lbl_2_1, lbl_3_1, lbl_4_1, lbl_5_1, lbl_6_1, lbl_7_1, lbl_8_1, lbl_9_1, lbl_10_1, lbl_11_1, lbl_12_1, lbl_13_1, lbl_14_1, lbl_15_1;
    @FXML
    private Label lbl_1_2, lbl_2_2, lbl_3_2, lbl_4_2, lbl_5_2, lbl_6_2, lbl_7_2, lbl_8_2, lbl_9_2, lbl_10_2, lbl_11_2, lbl_12_2, lbl_13_2, lbl_14_2, lbl_15_2;
    @FXML
    private Label lbl_1_3, lbl_2_3, lbl_3_3, lbl_4_3, lbl_5_3, lbl_6_3, lbl_7_3, lbl_8_3, lbl_9_3, lbl_10_3, lbl_11_3, lbl_12_3, lbl_13_3, lbl_14_3, lbl_15_3;
    @FXML
    private Label lbl_1_4, lbl_2_4, lbl_3_4, lbl_4_4, lbl_5_4, lbl_6_4, lbl_7_4, lbl_8_4, lbl_9_4, lbl_10_4, lbl_11_4, lbl_12_4, lbl_13_4, lbl_14_4, lbl_15_4;

    public void clickStartButton(ActionEvent event) {
        System.out.println("Word Search will display in GUI later...");
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
        lbl_15_3.setText("A");
        lbl_1_3.setText("A");
        lbl_4_3.setText("A");
    }

    public void onClick(MouseEvent mouseEvent) {
        changeLabel(lbl_1_1, "LOOKING");
        System.out.println("Presently just changes a column of letters to a new word when a letter label is clicked.");

    }
}