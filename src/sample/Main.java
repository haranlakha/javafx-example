package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//based off an example from https://examples.javacodegeeks.com/desktop-java/javafx/javafx-tutorial-beginners/
public class Main extends Application {
    //create the message textarea
    TextArea messageArea = new TextArea();
    @Override
    public void start(Stage primaryStage) {
        //create TextField
        final TextField input = new TextField();
        input.setPromptText("Input your message here");

        //message prompt and size for the TextArea
        messageArea.setPromptText("Your message");
        messageArea.setPrefColumnCount(10);
        messageArea.setPrefRowCount(10);

        //print button
        Button printButton = new Button("Print Message");
        //input clear button
        Button clearInputButton = new Button("Clear Input");
        //message clear button
        Button clearMessageButton = new Button("Clear Message");
        //clear all button
        Button clearAllButton = new Button("Clear All");

        //print button event handler
        printButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageArea.appendText(input.getText()+ "\n");
            }
        });

        //clear input button event handler
        clearInputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                input.clear();
            }
        });

        //clear message button event handler
        clearMessageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageArea.clear();
            }
        });

        //clear all button event handler
        clearAllButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageArea.clear();
                input.clear();
            }
        });

        // Create the HBox
        HBox buttonBox = new HBox();
        // Add the children to the HBox
        buttonBox.getChildren().addAll(printButton, clearInputButton, clearMessageButton, clearAllButton);
        // Set the vertical spacing between children to 15px
        buttonBox.setSpacing(15);
        buttonBox.setStyle("-fx-padding: 10;");
        //create the Vbox
        VBox root = new VBox();

        //add Labels, TextArea and TextField to the Vbox
        root.getChildren().addAll(new Label("Input:"), input, new Label("Messages:"), messageArea, buttonBox);
        //set minimum size
        root.setMinSize(350,350);
        /*
        * Set the padding of the Vbox
        * set the border-style of the Vbox
        * set the border-width of the Vbox
        * set the border-insets of the Vbox
        * set the border-radius of the Vbox
        * set the border-colour of the Vbox
        */
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");

        //create the scene
        Scene scene = new Scene(root);
        //add the scene to the stage
        primaryStage.setScene(scene);
        //set the title of the stage
        primaryStage.setTitle("Input Example");
        //display the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
