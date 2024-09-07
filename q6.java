import java.util.Scanner;

class Student {
    String name;
    int id;

    Student(String name,int id)
    {
        this.name = name;
        this.id = id;
    }
}

class Sports extends Student {
    int s_grade;

    Sports(String name,int id,int s_grade)
    {
        super(name, id);
        this.s_grade = s_grade;
    }
}

class Exam extends Sports {
    int e_grade;

    Exam(String name,int id,int s_grade,int e_grade)
    {
        super(name, id, s_grade);
        this.e_grade = e_grade;
    }
}

class Results extends Exam {
    String finalResult;
    Results(String name,int id,int s_grade,int e_grade,String finalResult) {
        super(name, id, s_grade, e_grade);
        this.finalResult = finalResult;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Sports Grade: " + s_grade);
        System.out.println("Exam Grade: " + e_grade);
        System.out.println("Final Result: " + finalResult);
    }
}

public class q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name,finalResult;
        int id,s_grade,e_grade;
        System.out.print("Enter name: ");
        name = scanner.nextLine();

        System.out.print("Enter ID: ");
        id = scanner.nextInt();

        System.out.print("Enter Sports grade: ");
        s_grade = scanner.nextInt();

        System.out.print("Enter Exam grade: ");
        e_grade = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter final result: ");
        finalResult = scanner.nextLine();
        Results results = new Results(name,id,s_grade,e_grade,finalResult);
        results.display();
        scanner.close();
    }
}