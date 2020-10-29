package wordsearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
//import java.awt.Label;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label1 = new Label("Z");
        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));

        Parent board = FXMLLoader.load(getClass().getResource("Board.fxml"));
        Scene newBoard = new Scene(board);

        primaryStage.setTitle("Word Search");
        primaryStage.setScene(newBoard);
        //primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();

        /*Stage stage2 = new Stage();

        stage2.setTitle("Second Window");

        stage2.setHeight(500);
        stage2.setWidth(500);

        stage2.setX(20);
        stage2.setY(20);
        stage2.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
