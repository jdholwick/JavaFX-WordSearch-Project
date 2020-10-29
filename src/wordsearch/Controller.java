package wordsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class Controller {

    @FXML
    private Label lbl_1_1;
    private Button btnButton1;

    public void clickStartButton(ActionEvent event) {
        System.out.println("Word Search will display in GUI later...");
    }

    public void clickExitButton(ActionEvent event) {
        System.out.println("Word Search will exit when clicked...");
        System.exit(0);
    }

    public void changeLabel(String newLabel) {
        lbl_1_1.setText(newLabel);
    }

    public void onClick(MouseEvent mouseEvent) { //ActionEvent event) {
        //Button button1 = (Button) mouseEvent.getSource();

        String labelLetter = lbl_1_1.getText();

        changeLabel("B");
        System.out.println("hi");

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