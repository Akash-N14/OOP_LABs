package lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class q3 extends Application {

    private Thread scrollingThread;
    private boolean scrollingLeft = true;
    private Text messageText;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scrolling Message");

        messageText = new Text("Hello, this is a scrolling message!");
        messageText.setStyle("-fx-font-size: 24px;");

        RadioButton leftToRightButton = new RadioButton("Scroll Left to Right");
        RadioButton rightToLeftButton = new RadioButton("Scroll Right to Left");
        ToggleGroup toggleGroup = new ToggleGroup();
        leftToRightButton.setToggleGroup(toggleGroup);
        rightToLeftButton.setToggleGroup(toggleGroup);
        leftToRightButton.setSelected(true);

        Button startButton = new Button("Start Scrolling");
        startButton.setOnAction(e -> startScrolling());

        Button stopButton = new Button("Stop Scrolling");
        stopButton.setOnAction(e -> stopScrolling());

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == leftToRightButton) {
                scrollingLeft = false;
            } else {
                scrollingLeft = true;
            }
        });

        VBox vbox = new VBox(10, messageText, leftToRightButton, rightToLeftButton, startButton, stopButton);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(vbox, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startScrolling() {
        if (scrollingThread == null || !scrollingThread.isAlive()) {
            scrollingThread = new Thread(() -> {
                double width = messageText.getLayoutBounds().getWidth();
                double sceneWidth = 600;
                double position = scrollingLeft ? sceneWidth : -width;

                while (true) {
                    position += scrollingLeft ? -1 : 1;
                    if (position < -width) {
                        position = 600;
                    } else if (position > sceneWidth) {
                        position = -width;
                    }
                    final double x = position;

                    javafx.application.Platform.runLater(() -> {
                        messageText.setTranslateX(x);
                    });

                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            scrollingThread.setDaemon(true);
            scrollingThread.start();
        }
    }

    private void stopScrolling() {
        if (scrollingThread != null && scrollingThread.isAlive()) {
            scrollingThread.interrupt();
            scrollingThread = null;
            messageText.setTranslateX(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
