package wordsearch;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class BoardController {

    @FXML
    private GridPane gpBoard;
    @FXML
    private Label lbl_0_0, lbl_0_1, lbl_0_2, lbl_0_3, lbl_0_4, lbl_0_5, lbl_0_6, lbl_0_7, lbl_0_8, lbl_0_9, lbl_0_10, lbl_0_11, lbl_0_12, lbl_0_13, lbl_0_14;
    @FXML
    private Label lbl_1_0, lbl_1_1, lbl_1_2, lbl_1_3, lbl_1_4, lbl_1_5, lbl_1_6, lbl_1_7, lbl_1_8, lbl_1_9, lbl_1_10, lbl_1_11, lbl_1_12, lbl_1_13, lbl_1_14;
    @FXML
    private Label lbl_2_0, lbl_2_1, lbl_2_2, lbl_2_3, lbl_2_4, lbl_2_5, lbl_2_6, lbl_2_7, lbl_2_8, lbl_2_9, lbl_2_10, lbl_2_11, lbl_2_12, lbl_2_13, lbl_2_14;
    @FXML
    private Label lbl_3_0, lbl_3_1, lbl_3_2, lbl_3_3, lbl_3_4, lbl_3_5, lbl_3_6, lbl_3_7, lbl_3_8, lbl_3_9, lbl_3_10, lbl_3_11, lbl_3_12, lbl_3_13, lbl_3_14;
    @FXML
    private Label lbl_4_0, lbl_4_1, lbl_4_2, lbl_4_3, lbl_4_4, lbl_4_5, lbl_4_6, lbl_4_7, lbl_4_8, lbl_4_9, lbl_4_10, lbl_4_11, lbl_4_12, lbl_4_13, lbl_4_14;
    @FXML
    private Label lbl_5_0, lbl_5_1, lbl_5_2, lbl_5_3, lbl_5_4, lbl_5_5, lbl_5_6, lbl_5_7, lbl_5_8, lbl_5_9, lbl_5_10, lbl_5_11, lbl_5_12, lbl_5_13, lbl_5_14;
    @FXML
    private Label lbl_6_0, lbl_6_1, lbl_6_2, lbl_6_3, lbl_6_4, lbl_6_5, lbl_6_6, lbl_6_7, lbl_6_8, lbl_6_9, lbl_6_10, lbl_6_11, lbl_6_12, lbl_6_13, lbl_6_14;
    @FXML
    private Label lbl_7_0, lbl_7_1, lbl_7_2, lbl_7_3, lbl_7_4, lbl_7_5, lbl_7_6, lbl_7_7, lbl_7_8, lbl_7_9, lbl_7_10, lbl_7_11, lbl_7_12, lbl_7_13, lbl_7_14;
    @FXML
    private Label lbl_8_0, lbl_8_1, lbl_8_2, lbl_8_3, lbl_8_4, lbl_8_5, lbl_8_6, lbl_8_7, lbl_8_8, lbl_8_9, lbl_8_10, lbl_8_11, lbl_8_12, lbl_8_13, lbl_8_14;
    @FXML
    private Label lbl_9_0, lbl_9_1, lbl_9_2, lbl_9_3, lbl_9_4, lbl_9_5, lbl_9_6, lbl_9_7, lbl_9_8, lbl_9_9, lbl_9_10, lbl_9_11, lbl_9_12, lbl_9_13, lbl_9_14;
    @FXML
    private Label lbl_10_0, lbl_10_1, lbl_10_2, lbl_10_3, lbl_10_4, lbl_10_5, lbl_10_6, lbl_10_7, lbl_10_8, lbl_10_9, lbl_10_10, lbl_10_11, lbl_10_12, lbl_10_13, lbl_10_14;
    @FXML
    private Label lbl_11_0, lbl_11_1, lbl_11_2, lbl_11_3, lbl_11_4, lbl_11_5, lbl_11_6, lbl_11_7, lbl_11_8, lbl_11_9, lbl_11_10, lbl_11_11, lbl_11_12, lbl_11_13, lbl_11_14;
    @FXML
    private Label lbl_12_0, lbl_12_1, lbl_12_2, lbl_12_3, lbl_12_4, lbl_12_5, lbl_12_6, lbl_12_7, lbl_12_8, lbl_12_9, lbl_12_10, lbl_12_11, lbl_12_12, lbl_12_13, lbl_12_14;
    @FXML
    private Label lbl_13_0, lbl_13_1, lbl_13_2, lbl_13_3, lbl_13_4, lbl_13_5, lbl_13_6, lbl_13_7, lbl_13_8, lbl_13_9, lbl_13_10, lbl_13_11, lbl_13_12, lbl_13_13, lbl_13_14;
    @FXML
    private Label lbl_14_0, lbl_14_1, lbl_14_2, lbl_14_3, lbl_14_4, lbl_14_5, lbl_14_6, lbl_14_7, lbl_14_8, lbl_14_9, lbl_14_10, lbl_14_11, lbl_14_12, lbl_14_13, lbl_14_14;

    public Node getNodeByCoords (GridPane gridPane, int row, int column) { // This method is the start of an attempt to get each label off the gridpane by column and row.
        Node curNode = null;
        System.out.println(gridPane);
        ObservableList<Node> children = gridPane.getChildren(); // creates ObservableList of Nodes from the gridPane rows and columns

        for (Node node : children) { // should iterate over each element in the ObservableList children until the one from parameters row and column is found
            if (gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row) {
                curNode = node;
                break;
            }
        }

        return curNode;
    }

    public void changeLabel(/*Label curLblName, */String newLabel) {
        //curLblName.setText(String.valueOf(newLabel.charAt(0)));
        lbl_0_0.setText(String.valueOf(newLabel.charAt(0)));
        lbl_1_1.setText(String.valueOf(newLabel.charAt(1)));
        lbl_2_2.setText(String.valueOf(newLabel.charAt(2)));
        lbl_3_3.setText(String.valueOf(newLabel.charAt(3)));
        lbl_4_4.setText(String.valueOf(newLabel.charAt(4)));
        lbl_5_5.setText(String.valueOf(newLabel.charAt(5)));
        lbl_6_6.setText(String.valueOf(newLabel.charAt(6)));
        lbl_0_7.setText("F");
        lbl_1_8.setText("O");
        lbl_2_9.setText("R");

        Node curNode = getNodeByCoords(gpBoard, 3, 3);
        //System.out.println(gpBoard);
        System.out.println(curNode);
    }

    public void onClick(MouseEvent mouseEvent) {
        changeLabel(/*lbl_0_0, */"LOOKING");
        System.out.println("Presently just changes a diagonal of letters to a new word when a letter label is clicked.");

    }
}