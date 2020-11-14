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

    private int[][] placedWordMap = new int[15][15]; // Will hold coordinates of any placed words so they don't get overwritten on the board.

    public Node getNodeByCoords(GridPane gridPane, int column, int row) { // This method is the start of an attempt to get each label off the gridpane by column and row.
        Node curNode = null;
        ObservableList<Node> children = gridPane.getChildren(); // creates ObservableList of Nodes from the gridPane rows and columns

        for (Node node : children) { // should iterate over each element in the ObservableList, children, until the one from parameters row and column is found
            if (gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row) {
                curNode = node;
                break;
            }
        }

        System.out.println(curNode.getId());
        return curNode;
    }

    public void putRandLettersOnBoard() {
        Random rand = new Random();
        Node curNode = null;

        // Nested for-loop iterates through columns and then through rows and sets each curNode cast to a Label with a random letter.
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                curNode = getNodeByCoords(gpBoard, i, j);

                String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

                ((Label) curNode).setText(Character.toString(alphabet.charAt(rand.nextInt(alphabet.length()))));

            }
        }


        // These are two temporary words I will use to initially put on the board.
        String word1 = "###########";
        String word2 = "*********";

        // Places words randomly on board
        placeRandomWord(word1);
        placeRandomWord(word2);


    }

    public void placeRandomWord(String randWord) {
        Node curNode = null;
        Random rand = new Random();
        int randRowCoord = rand.nextInt(15); // random int between 0 and 14
        int randColCoord = rand.nextInt(15); // random int between 0 and 14
        boolean bWordCross = true; // set true initially to enter while loop

        while (bWordCross == true) {
            while ((randRowCoord + randWord.length()) > 14) { // Ensures we stay within bounds of board.
                randRowCoord = rand.nextInt(15);
            }

            while (randColCoord > 14) { // Ensures we stay within bounds of board.
                randColCoord = rand.nextInt(15);
            }

            bWordCross = false; // Set to false again here to enter loop that will check for word crossing.

            for(int i = 0; i <= randWord.length(); i++) {
                System.out.println(randRowCoord + i);
                System.out.println(randColCoord);

                if (placedWordMap[randColCoord][randRowCoord + i] == 1) {
                    System.out.println("Overlap found!");
                    randRowCoord = 100; // Forces new rands to be found when loop restarts.
                    randColCoord = 100; // Forces new rands to be found when loop restarts.
                    bWordCross = true;
                    break;
                }
            }
        }

        for(int i = 0; i < randWord.length(); i++) {
            curNode = getNodeByCoords(gpBoard, randColCoord, randRowCoord + i); // Uses randRowCoord + i to move down for each new letter to add.
            ((Label) curNode).setText((Character.toString(randWord.charAt(i))));
            placedWordMap[randColCoord][randRowCoord + i] = 1; // A 1 on the map indicates a letter is there.
        }

    }

    public void onLabelClick(MouseEvent mouseEvent) {
        Node source = (Node)mouseEvent.getSource() ;
        Integer colCoord = GridPane.getColumnIndex(source);
        Integer rowCoord = GridPane.getRowIndex(source);
        System.out.printf("You clicked a letter located at column and row, [%d, %d]%n", colCoord.intValue(), rowCoord.intValue());
    }

    public void onClick(MouseEvent mouseEvent) {
        putRandLettersOnBoard();

        // This is temporary just so we can see what our placedWordMap looks like.
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                System.out.print(placedWordMap[col][row] + " ");
            }
            System.out.println("");
        }

        System.out.println("Now changes board to a board of random letters.");


        placedWordMap = new int[15][15]; // Resets array to 0s.

    }
}