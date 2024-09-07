import java.util.Scanner;
class STUDENT {
    String name;
    int rollNumber;
    int totalMarks;
    double averageMarks;

    public STUDENT(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public void compute() {
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
    public ScienceStudent(String name, int rollNumber, int practicalMarks) {
        super(name, rollNumber);
        this.practicalMarks = practicalMarks;
    }
    public void compute() {
        totalMarks = practicalMarks;
        averageMarks = totalMarks;
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
    private int subjectMarks;
    private String electiveSubject;
    public ArtsStudent(String name, int rollNumber, int subjectMarks, String electiveSubject) {
        super(name, rollNumber);
        this.subjectMarks = subjectMarks;
        this.electiveSubject = electiveSubject;
    }
    public void compute() {
        totalMarks = subjectMarks;
        averageMarks = totalMarks;
    }
    public void display() {
        super.display();
        System.out.println("Subject Marks: " + subjectMarks);
        System.out.println("Elective Subject: " + electiveSubject);
    }
}
public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter practical marks for Science student: ");
        int practicalMarks = scanner.nextInt();
        scanner.nextLine();
        ScienceStudent scienceStudent = new ScienceStudent(name, rollNumber, practicalMarks);
        scienceStudent.compute();
        scienceStudent.display();
        System.out.print("Enter subject marks for Arts student: ");
        int subjectMarks = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter elective subject for Arts student: ");
        String electiveSubject = scanner.nextLine();
        ArtsStudent artsStudent = new ArtsStudent(name, rollNumber, subjectMarks, electiveSubject);
        artsStudent.compute();
        artsStudent.display();
        scanner.close();
    }
}