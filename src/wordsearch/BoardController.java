package wordsearch;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.Random;


public class BoardController {

    @FXML
    private GridPane gpBoard;


    public Node getNodeByCoords(GridPane gridPane, int row, int column) { // This method is the start of an attempt to get each label off the gridpane by column and row.
        Node curNode = null;
        ObservableList<Node> children = gridPane.getChildren(); // creates ObservableList of Nodes from the gridPane rows and columns

        for (Node node : children) { // should iterate over each element in the ObservableList children until the one from parameters row and column is found
            if (gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row) {
                curNode = node;
                break;
            }
        }

        return curNode;
    }

    public void createBoard() {
        Random rand = new Random();
        Node curNode = null;

        // Nested for-loop iterates through rows and then through columns and sets each curNode cast to a Label with a random letter.
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                curNode = getNodeByCoords(gpBoard, i, j);

                String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

                ((Label) curNode).setText(Character.toString(alphabet.charAt(rand.nextInt(alphabet.length()))));

            }
        }


        // These are two temporary words I will use to initially put on the board.
        String word1 = "*****";
        String word2 = "######";

        // Places words randomly on board
        placeRandomWord(word1);


    }

    public void placeRandomWord(String randWord) {
        Node curNode = null;
        Random rand = new Random();
        int randCoord = rand.nextInt(15); // random int between 0 and 14

        for(int i = 0; i < randWord.length(); i++) {
            System.out.println(randCoord + i);
            if ((randCoord + i) < 15) {
                curNode = getNodeByCoords(gpBoard, randCoord + i, 0);
                ((Label) curNode).setText((Character.toString(randWord.charAt(i))));
            }
        }

    }

    public void onClick(MouseEvent mouseEvent) {
        createBoard();
        System.out.println("Now changes board to a board of random letters.");

    }
}