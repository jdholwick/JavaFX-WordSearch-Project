package wordsearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        Scene newMenu = new Scene(root);

        Parent board = FXMLLoader.load(getClass().getResource("Board.fxml"));
        Scene newBoard = new Scene(board);

        primaryStage.setTitle("Word Search Menu");
        primaryStage.setScene(newMenu);
        primaryStage.show();


        Stage boardStage = new Stage();

        boardStage.setTitle("Letter Board");
        boardStage.setScene(newBoard);

        boardStage.setX(20);
        boardStage.setY(20);
        boardStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
