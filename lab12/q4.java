package lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class q4 extends Application {

    private List<Student> students;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Details");

        students = createStudentList();
        ListView<String> listView = new ListView<>();
        for (Student student : students) {
            listView.getItems().add(student.getRegNumber());
        }

        canvas = new Canvas(400, 400);
        Button displayButton = new Button("Display Details");

        displayButton.setOnAction(e -> {
            String selectedRegNumber = listView.getSelectionModel().getSelectedItem();
            if (selectedRegNumber != null) {
                displayStudentDetails(selectedRegNumber);
            }
        });

        VBox vbox = new VBox(10, listView, displayButton, canvas);
        Scene scene = new Scene(vbox, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Student> createStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("101", "Alice", "Computer Science", "A"));
        studentList.add(new Student("102", "Bob", "Electrical Engineering", "B"));
        studentList.add(new Student("103", "Charlie", "Mathematics", "A"));
        studentList.add(new Student("104", "Diana", "Biology", "B"));
        return studentList;
    }

    private void displayStudentDetails(String regNumber) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Student student : students) {
            if (student.getRegNumber().equals(regNumber)) {
                gc.fillText("Registration Number: " + student.getRegNumber(), 20, 50);
                gc.fillText("Name: " + student.getName(), 20, 70);
                gc.fillText("Course: " + student.getCourse(), 20, 90);
                gc.fillText("Grade: " + student.getGrade(), 20, 110);
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Student {
        private String regNumber;
        private String name;
        private String course;
        private String grade;

        public Student(String regNumber, String name, String course, String grade) {
            this.regNumber = regNumber;
            this.name = name;
            this.course = course;
            this.grade = grade;
        }

        public String getRegNumber() {
            return regNumber;
        }

        public String getName() {
            return name;
        }

        public String getCourse() {
            return course;
        }

        public String getGrade() {
            return grade;
        }
    }
}
