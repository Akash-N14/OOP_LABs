package lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class q2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        Label lblName = new Label("Name:");
        TextField txtName = new TextField();
        Label lblAge = new Label("Age:");
        TextField txtAge = new TextField();
        Label lblAddress = new Label("Address:");
        TextField txtAddress = new TextField();

        Label lblLanguages = new Label("Languages Known:");
        CheckBox chkEnglish = new CheckBox("English");
        CheckBox chkSpanish = new CheckBox("Spanish");
        CheckBox chkFrench = new CheckBox("French");
        CheckBox chkGerman = new CheckBox("German");

        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button btnSubmit = new Button("Submit");

        btnSubmit.setOnAction(e -> {
            String name = txtName.getText();
            String age = txtAge.getText();
            String address = txtAddress.getText();

            List<String> languages = new ArrayList<>();
            if (chkEnglish.isSelected())
                languages.add("English");
            if (chkSpanish.isSelected())
                languages.add("Spanish");
            if (chkFrench.isSelected())
                languages.add("French");
            if (chkGerman.isSelected())
                languages.add("German");

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.fillText("Resume", 10, 20);
            gc.fillText("Name: " + name, 10, 50);
            gc.fillText("Age: " + age, 10, 70);
            gc.fillText("Address: " + address, 10, 90);
            gc.fillText("Languages Known: " + String.join(", ", languages), 10, 110);
        });

        grid.add(lblName, 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(lblAge, 0, 1);
        grid.add(txtAge, 1, 1);
        grid.add(lblAddress, 0, 2);
        grid.add(txtAddress, 1, 2);
        grid.add(lblLanguages, 0, 3);
        grid.add(chkEnglish, 1, 3);
        grid.add(chkSpanish, 1, 4);
        grid.add(chkFrench, 1, 5);
        grid.add(chkGerman, 1, 6);
        grid.add(btnSubmit, 1, 7);
        grid.add(canvas, 0, 8, 2, 1);

        Scene scene = new Scene(grid, 450, 400);
        primaryStage.setTitle("Resume Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
