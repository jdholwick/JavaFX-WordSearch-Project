package wordsearch;

import javafx.event.ActionEvent;

import java.awt.event.MouseEvent;

public class Controller {

    public void clickStartButton(ActionEvent event) {
        System.out.println("Word Search will display in GUI later...");
    }

    public void clickExitButton(ActionEvent event) {
        System.out.println("Word Search will exit when clicked...");
        System.exit(0);
    }

    public void onMouseClick(MouseEvent mouseEvent) {

    }
}


// The following is from 'Interface.fxml' and was altered once before destroying functionality, without my doing so, so I'm saving a copy of it here:
/*
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<GridPane alignment="center" hgap="10" prefHeight="300.0" prefWidth="300.0" vgap="10" xmlns="http://javafx.com/javafx/11.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="wordsearch.Controller">
   <columnConstraints>
      <ColumnConstraints />
   </columnConstraints>
   <rowConstraints>
      <RowConstraints />
   </rowConstraints>
   <children>
      <Button fx:id="btnNotify" mnemonicParsing="false" onAction="#clickStartButton" text="Button" />
   </children>
</GridPane>

 */