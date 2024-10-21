package lab11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class q3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome");
        Label userNameLabel = new Label("User Name:");
        Label passwordLabel = new Label("Password:");

        TextField userNameField = new TextField();
        userNameField.setPromptText("Enter your username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        Label welcomeMessage = new Label();

        Button signInButton = new Button("Sign in");

        signInButton.setOnAction(event -> {
            String userName = userNameField.getText();
            welcomeMessage.setText("Welcome " + userName);
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(welcomeLabel, 0, 0, 2, 1);
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(userNameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(welcomeMessage, 0, 3, 2, 1);
        gridPane.add(signInButton, 1, 4);

        Scene scene = new Scene(gridPane, 400, 200);

        primaryStage.setTitle("JavaFX Welcome");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
