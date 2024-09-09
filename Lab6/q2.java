class EMPLOYEE {
    String name;
    double basicSalary;

    EMPLOYEE(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class FullTimeEmp extends EMPLOYEE {
    double bonus;
    double deductions;

    FullTimeEmp(String name, double basicSalary, double bonus, double deductions) {
        super(name, basicSalary);
        this.bonus = bonus;
        this.deductions = deductions;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus - deductions;
    }

    @Override
    void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Bonus: " + bonus);
        System.out.println("Deductions: " + deductions);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class PartTimeEmp extends EMPLOYEE {
    int hoursWorked;
    static final double hourlyRate = 20.0;

    PartTimeEmp(String name, double basicSalary, int hoursWorked) {
        super(name, basicSalary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

public class q2 {
    public static void main(String[] args) {
        FullTimeEmp fullTimeEmployee = new FullTimeEmp("Akshat", 5000, 800, 200);
        PartTimeEmp partTimeEmployee = new PartTimeEmp("Animesh", 0, 120);
        System.out.println("Full Time Employee Details:");
        fullTimeEmployee.displayEmployeeDetails();
        System.out.println("\nPart Time Employee Details:");
        partTimeEmployee.displayEmployeeDetails();
    }
}
