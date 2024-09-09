import java.util.Scanner;
class STUDENT {
    String name;
    int rollNumber;
    int[] marks;
    int totalMarks;
    double averageMarks;

    public STUDENT(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void compute() {
        totalMarks = 0;
        for(int mark:marks)
        {
            totalMarks += mark;
        }
        averageMarks = totalMarks / marks.length;
    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
    }
}
class ScienceStudent extends STUDENT {
    private int practicalMarks;

    public ScienceStudent(String name, int rollNumber, int[] marks, int practicalMarks) {
        super(name, rollNumber,marks);
        this.practicalMarks = practicalMarks;
    }

    public void compute() {
        super.compute();
        totalMarks +=practicalMarks ;
        averageMarks = totalMarks/(marks.length+1);
    }
    public void displayPracticalMarks() {
        System.out.println("Practical Marks: " + practicalMarks);
    }
    public void display() {
        super.display();
        displayPracticalMarks();
    }
}
class ArtsStudent extends STUDENT {
    private String electiveSubject;
    public ArtsStudent(String name, int rollNumber, int[] marks, String electiveSubject) {
        super(name, rollNumber,marks);
        this.electiveSubject = electiveSubject;
    }
    public void display() {
        super.display();
        System.out.println("Elective Subject: " + electiveSubject);
    }
}
public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = { 90, 67, 89, 60, 66 };
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter practical marks for Science student: ");
        int practicalMarks = scanner.nextInt();
        scanner.nextLine();
        ScienceStudent scienceStudent = new ScienceStudent(name, rollNumber, marks, practicalMarks);
        scienceStudent.compute();
        scienceStudent.display();
        scanner.nextLine();
        System.out.print("Enter elective subject for Arts student: ");
        String electiveSubject = scanner.nextLine();
        ArtsStudent artsStudent = new ArtsStudent(name, rollNumber, marks, electiveSubject);
        artsStudent.compute();
        artsStudent.display();
        scanner.close();
    }
}