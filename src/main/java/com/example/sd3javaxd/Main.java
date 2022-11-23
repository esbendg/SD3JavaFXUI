package com.example.sd3javaxd;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    Button button2;

    Button button3;

    @Override
    public void start(Stage stage) throws IOException {

        DataQuery dataQuery = new DataQuery();
        dataQuery.getData();

        //creating the window
        window = stage;
        window.setTitle("CargoHelper");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        /*
        Creating a choicebox and button for confirming
         */
        button =new Button("Confirm choice");
        List<String> myList = new ArrayList(dataQuery.getData());
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(myList));
        choiceBox.setValue("NA");
        layout.getChildren().addAll(choiceBox);
        layout.getChildren().addAll(button);
        /*
        Creating a choicebox2 and button2 for confirming second choice
         */
        button2 =new Button("Confirm choice");
        List<String> myList2 = new ArrayList(dataQuery.getData());
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>(FXCollections.observableArrayList(myList2));
        choiceBox2.setValue("NA");
        layout.getChildren().addAll(choiceBox2);
        layout.getChildren().addAll(button2);

        //Creating text field
        TextField textField = new TextField();
        button3 =new Button("Find vessel");
        layout.getChildren().addAll(textField);
        layout.getChildren().addAll(button3);

        //Using the method getChoice to confirm a selected port
        button.setOnAction(e -> getChoice(choiceBox));
        button2.setOnAction(e -> getChoice(choiceBox2));
        button3.setOnAction(e -> getAmount(textField));

        //Displaying the interface
        scene = new Scene(layout,330,330);
        window.setScene(scene);
        window.show();
    }
    public void getChoice (ChoiceBox<String> choiceBox){
        String firstChoice = choiceBox.getValue();
        System.out.println(firstChoice);

    }
    public void getAmount (TextField textField){
        DataQuery dq = new DataQuery();
        String amount = textField.getText();
        System.out.println(amount);
        dq.findVessel(amount);
        System.out.println(dq.findVessel(amount));
    }

    public static void main(String[] args) {

        launch();

    }
}
