package wordsearch;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class BoardController {

    @FXML
    private GridPane gpBoard;

    private int iNumWordsInDict = 0;
    private int[][] placedWordMap = new int[15][15]; // Will hold coordinates of any placed words so they don't get overwritten on the board.
    private int[][][] hiddenWordCoords = new int[iNumWordsInDict][2][2]; // Will hold specific coordinates of each word on grid so they can be matched with coordinates of clicks. 3d so that each word can have two sets of coordinates stored for it.
    private int[][] clickedLetters = new int[2][2]; // Will hold coordinates of first and last letter clicked
    private boolean bFirstClick = true; // Used to determine which letter click we are on. True to begin with because first click is always on first letter of "word."
    private int iHiddenWordIter = 0; // This will be incremented everytime a new word is added to the puzzle. It is used to index the 3d hiddenWordCoords.
    private boolean bWordFileRead = false; // Used to ensure we only load word dictionary once.

    private List<Integer> listFoundWords = new ArrayList<Integer>();
    private List<String> listWords = new ArrayList<String>();

    public void readWordFile() {

        try
        {
            File wordFile = new File("src\\wordsearch\\words.txt"); // Words are all lowercase for now as I want them to be easily seen on board of uppercase letters while testing.
            Scanner sc = new Scanner(wordFile);

            for (int i = 0; (i < 4) && sc.hasNextLine(); i++){ // Limit of four is just for testing. We should up that later.
                listWords.add(sc.nextLine());
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Problem importing word file. Exiting App.");
            System.exit(0);
        }

    }

    public Node getNodeByCoords(GridPane gridPane, int column, int row) { // This method is the start of an attempt to get each label off the gridpane by column and row.
        Node curNode = null;
        ObservableList<Node> children = gridPane.getChildren(); // creates ObservableList of Nodes from the gridPane rows and columns

        for (Node node : children) { // should iterate over each element in the ObservableList, children, until the one from parameters row and column is found
            if (gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row) {
                curNode = node;
                break;
            }
        }

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

        // Places words randomly on board
        for (int i = 0; i < listWords.size(); i++) { // for testing
                placeRandomWord(listWords.get(i), "vertical");
        }


    }

    public void placeRandomWord(String randWord, String sWordDirection) {
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

            for(int i = 0; i <= randWord.length(); i++) { // For VERTICAL words.
                if (placedWordMap[randColCoord][randRowCoord + i] == 1) {
                    //System.out.println("Overlap found!"); // for testing
                    randRowCoord = 100; // Forces new rands to be found when loop restarts.
                    randColCoord = 100; // Forces new rands to be found when loop restarts.
                    bWordCross = true;
                    break;
                }
            }
        }

        for(int i = 0; i < randWord.length(); i++) {
            curNode = getNodeByCoords(gpBoard, randColCoord, randRowCoord + i); // Uses randRowCoord + i to move down for each new letter to add.

            ((Label)curNode).setText((Character.toString(randWord.charAt(i))));
            placedWordMap[randColCoord][randRowCoord + i] = 1; // A 1 on the map indicates a letter is there.
        }

        hiddenWordCoords[iHiddenWordIter][0][0] = randColCoord; // Marks coords for beginning of VERTICAL word.
        hiddenWordCoords[iHiddenWordIter][0][1] = randRowCoord; // Marks coords for beginning of VERTICAL word.
        hiddenWordCoords[iHiddenWordIter][1][0] = randColCoord; // Marks coords for end of VERTICAL word.
        hiddenWordCoords[iHiddenWordIter][1][1] = randRowCoord + randWord.length() - 1; // Marks coords for end of VERTICAL word. Subtract 1 to account for randRowCoord being the first letter of the word.

        iHiddenWordIter++; // When next word is placed this will ensure it takes a different spot in the array.

    }

    public void onLabelMousePress(MouseEvent mouseEvent) {
        if (listFoundWords.size() < iNumWordsInDict) { // As soon as all words are found, a click should just print a message as it does in the else statement below.
            Node source = (Node) mouseEvent.getSource();
            Integer colCoord = GridPane.getColumnIndex(source);
            Integer rowCoord = GridPane.getRowIndex(source);

            if (bFirstClick == true) {
                clickedLetters[0][0] = colCoord; // Marks coords for beginning of the word.
                clickedLetters[0][1] = rowCoord; // Marks coords for beginning of the word.
                bFirstClick = false; // So next recorded click will be second letter.
            } else if (bFirstClick == false) {
                clickedLetters[1][0] = colCoord; // Marks coords for end of the word.
                clickedLetters[1][1] = rowCoord; // Marks coords for end of the word.
                bFirstClick = true; // So next recorded click will start cycle over and record first letter.

                for (int i = iHiddenWordIter - 1; i >= 0; i--) { // iHiddenWordIter is subracted by 1 because it is incremented once superfluously at the end of placeRandomWord.
                    if (((clickedLetters[0][0] == hiddenWordCoords[i][0][0]) &&
                            (clickedLetters[0][1] == hiddenWordCoords[i][0][1]) &&
                            (clickedLetters[1][0] == hiddenWordCoords[i][1][0]) &&
                            (clickedLetters[1][1] == hiddenWordCoords[i][1][1])) ||
                            ((clickedLetters[1][0] == hiddenWordCoords[i][0][0]) &&
                                    (clickedLetters[1][1] == hiddenWordCoords[i][0][1]) &&
                                    (clickedLetters[0][0] == hiddenWordCoords[i][1][0]) &&
                                    (clickedLetters[0][1] == hiddenWordCoords[i][1][1]))) {

                        // Maybe more convoluted than it needs to be but twe'll keep track of what's been found by converting coordinates to a string and then back to a long integer number and storing in a list so we can search for that number should the same word be clicked.
                        String sTemp0 = Integer.toString(hiddenWordCoords[i][0][0]);
                        String sTemp1 = Integer.toString(hiddenWordCoords[i][0][1]);
                        String sTemp2 = Integer.toString(hiddenWordCoords[i][1][0]);
                        String sTemp3 = Integer.toString(hiddenWordCoords[i][1][1]);
                        String sTempFinal = sTemp0 + sTemp1 + sTemp2 + sTemp3;

                        if (listFoundWords.contains(Integer.parseInt(sTempFinal))) {
                            System.out.println("You already found this word.");
                        } else {
                            listFoundWords.add(Integer.parseInt(sTempFinal));
                            System.out.println("You found a word!");
                        }


                        for (int j = hiddenWordCoords[i][0][1]; j <= hiddenWordCoords[i][1][1]; j++) { // Will change the appearance of a word once you find it so it stands out.
                            Node curNode = getNodeByCoords(gpBoard, hiddenWordCoords[i][0][0], j);
                            ((Label) curNode).setStyle("-fx-font-weight: bold; -fx-text-fill: #df6124;");

                        }

                        break;

                    } else if (i == 0) { // This way we don't print this every time we don't match from the list of words on the board.
                        System.out.println("Not a word... Keep trying.");
                    }

                }

            }
        } else {
            System.out.println("All words found! Thanks for playing!");
        }


    }

    public void onClickStartBtn(MouseEvent mouseEvent) {
        if (bWordFileRead == false) { // If the word dictionary hasn't been read we know this is the initial run and so after initial run, this will disable the start button. I would like to fix the start button though so that the board resets instead of locking probably.
            readWordFile();
            bWordFileRead = true;

            iNumWordsInDict = listWords.size();

            // The following variables of this class are reset for a new game board:
            placedWordMap = new int[15][15];
            hiddenWordCoords = new int[iNumWordsInDict][2][2];
            clickedLetters = new int[2][2];
            bFirstClick = true;
            iHiddenWordIter = 0;


            putRandLettersOnBoard();

            System.out.println("Find these words:");

            for (int i = 0; i < listWords.size(); i++) { // Prints out the words that need to be found.
                System.out.println("   " + listWords.get(i));
            }

            // This is temporary just so we can see what our placedWordMap looks like. I.e., for testing.
        /*for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                System.out.print(placedWordMap[col][row] + " ");
            }
            System.out.println("");
        }*/

        } else {
            System.out.println("Can't initiate a board again. Close this board to start a new one from main menu.");
        }

    }
}