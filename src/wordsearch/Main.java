package wordsearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label1 = new Label("Z");
        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        Scene newMenu = new Scene(root);

        Parent board = FXMLLoader.load(getClass().getResource("Board.fxml"));
        Scene newBoard = new Scene(board);

        primaryStage.setTitle("Word Search");
        primaryStage.setScene(newMenu);
        //primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();


        Stage boardStage = new Stage();

        boardStage.setTitle("Second Window");
        boardStage.setScene(newBoard);

        //boardStage.setHeight(500);
        //boardStage.setWidth(500);

        boardStage.setX(20);
        boardStage.setY(20);
        boardStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
