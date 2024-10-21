package lab11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class Employee {
    String name;
    String empID;
    String designation;
    double basicPay;
    double DA;
    double HRA;
    double PF;
    double LIC;
    double netSalary;
    public Employee(String name, String empID, String designation, double basicPay, double LIC) {
        this.name = name;
        this.empID = empID;
        this.designation = designation;
        this.basicPay = basicPay;
        this.LIC = LIC;
        calculateSalary();
    }

    public void calculateSalary() {
        DA = 0.40 * basicPay;
        HRA = 0.15 * basicPay;
        PF = 0.12 * basicPay;
        netSalary = basicPay + DA + HRA - PF - LIC;
    }

    public String getAll() {
        return "Employee Information:\n" +
                "Name: " + name + "\n" +
                "Employee ID: " + empID + "\n" +
                "Designation: " + designation + "\n" +
                "Basic Pay: " + basicPay + "\n" +
                "DA: " + DA + "\n" +
                "HRA: " + HRA + "\n" +
                "PF: " + PF + "\n" +
                "LIC: " + LIC + "\n" +
                "Net Salary: " + netSalary;
    }
}

public class q4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label empIDLabel = new Label("Employee ID:");
        TextField empIDField = new TextField();

        Label designationLabel = new Label("Designation:");
        TextField designationField = new TextField();

        Label basicPayLabel = new Label("Basic Pay:");
        TextField basicPayField = new TextField();

        Label licLabel = new Label("LIC Deduction:");
        TextField licField = new TextField();


        Button displayButton = new Button("Display Employee Info");

        Label resultLabel = new Label();

        displayButton.setOnAction(event -> {
            String name = nameField.getText();
            String empID = empIDField.getText();
            String designation = designationField.getText();
            double basicPay = Double.parseDouble(basicPayField.getText());
            double LIC = Double.parseDouble(licField.getText());

            Employee employee = new Employee(name, empID, designation, basicPay, LIC);

            resultLabel.setText(employee.getAll());
        });

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(nameLabel, nameField, empIDLabel, empIDField,
                designationLabel, designationField, basicPayLabel, basicPayField,
                licLabel, licField, displayButton, resultLabel);

        Scene scene = new Scene(flowPane, 500, 300);
        primaryStage.setTitle("Employee Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
