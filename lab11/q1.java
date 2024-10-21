package lab11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class q1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Welcome to JavaFX programming");
        label.setTextFill(Color.MAGENTA);

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(20);
        flowPane.setVgap(20);
        flowPane.getChildren().add(label);

        Scene scene = new Scene(flowPane, 500, 200);

        primaryStage.setTitle("This is the first JavaFX Application");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
