package lab11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class q2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label instructionLabel = new Label("Enter a number: ");
        TextField numberField = new TextField();
        numberField.setPromptText("Enter an integer");
        Label resultLabel = new Label();

        Button generateButton = new Button("Generate Table");

        generateButton.setOnAction(event -> {
            // Get the number entered by the user
            int number = Integer.valueOf(numberField.getText());
            String table = ""; 

            for (int i = 1; i <= 10; i++) {
                table += number + " x " + i + " = " + (number * i) + "\n";
            }

            resultLabel.setText(table);
        });

        FlowPane flowPane = new FlowPane(20, 20);
        flowPane.getChildren().addAll(instructionLabel, numberField, generateButton, resultLabel);

        Scene scene = new Scene(flowPane, 400, 300);

        primaryStage.setTitle("Multiplication Table Generator");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
