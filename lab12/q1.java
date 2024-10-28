package lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class q1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Label lblNum1 = new Label("Number 1:");
        TextField txtNum1 = new TextField();
        Label lblNum2 = new Label("Number 2:");
        TextField txtNum2 = new TextField();
        Canvas canvas = new Canvas(300, 150);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Button btnCompute = new Button();
        Image calculatorImage = new Image("file:calculator.png");
        btnCompute.setGraphic(new javafx.scene.image.ImageView(calculatorImage));
        btnCompute.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(txtNum1.getText());
                double num2 = Double.parseDouble(txtNum2.getText());

                double sum = num1 + num2;
                double difference = num1 - num2;
                double product = num1 * num2;
                double quotient = num2 != 0 ? num1 / num2 : Double.NaN;

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.fillText("Sum: " + sum, 10, 20);
                gc.fillText("Difference: " + difference, 10, 40);
                gc.fillText("Product: " + product, 10, 60);
                gc.fillText("Quotient: " + quotient, 10, 80);
            } catch (NumberFormatException ex) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.fillText("Invalid input, please enter numbers", 10, 20);
            }
        });

        grid.add(lblNum1, 0, 0);
        grid.add(txtNum1, 1, 0);
        grid.add(lblNum2, 0, 1);
        grid.add(txtNum2, 1, 1);
        grid.add(btnCompute, 1, 2);
        grid.add(canvas, 0, 3, 2, 1);
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Calculator App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
