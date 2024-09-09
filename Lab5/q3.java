import java.util.GregorianCalendar;
import java.util.Arrays;
import java.util.Comparator;
import java.text.SimpleDateFormat;

class Student {
    int reg_no;
    String full_name;
    GregorianCalendar dateofjoin;
    short sem;
    float gpa;
    float cgpa;

    Student(String full_name, GregorianCalendar dateofjoin, short sem, float gpa, float cgpa, int count) {
        this.full_name = full_name;
        this.dateofjoin = dateofjoin;
        this.sem = sem;
        this.gpa = gpa;
        this.cgpa = cgpa;
        this.reg_no = generateReg_no(dateofjoin.get(GregorianCalendar.YEAR), count);
    }

    public int generateReg_no(int year, int count) {
        return (year % 100) * 100 + count;
    }

    public void displayRecord() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = sdf.format(dateofjoin.getTime());

        System.out.println("Registration Number: " + reg_no);
        System.out.println("Full name: " + full_name);
        System.out.println("Date of Joining: " + dateStr);
        System.out.println("Semester: " + sem);
        System.out.println("GPA: " + gpa);
        System.out.println("CGPA: " + cgpa);
    }

    public String getFullName() {
        return full_name;
    }

    public short getSemester() {
        return sem;
    }

    public float getCGPA() {
        return cgpa;
    }

    public void modifyname() {
        String[] parts = full_name.split(" ");
        StringBuilder newname = new StringBuilder();
        for (int i = 0; i < parts.length - 1; i++) {
            newname.append(parts[i].charAt(0)).append(".");
        }
        newname.append(parts[parts.length - 1]);
        this.full_name = newname.toString();
    }

    public static void display(Student[] students) {
        for (Student student : students) {
            student.displayRecord();
            System.out.println("---------------------");
        }
    }

    public static void liststudents(Student[] students, char s) {
        for (Student student : students) {
            if (student.getFullName().charAt(0) == s) {
                student.displayRecord();
                System.out.println("---------------------");
            }
        }
    }

    public static void substring(Student[] students, String sub) {
        for (Student student : students) {
            if (student.getFullName().contains(sub)) {
                student.displayRecord();
                System.out.println("---------------------");
            }
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        // Adjust the month (0-based index)
        students[0] = new Student("John Doe", new GregorianCalendar(2022, 7, 15), (short) 3, (float) 8.7, (float) 8.6,
                1);
        students[1] = new Student("Mike Smith", new GregorianCalendar(2023, 6, 10), (short) 1, (float) 9.67,
                (float) 9.62, 2);

        System.out.println("The records are: ");
        for (Student student : students) {
            student.displayRecord();
            System.out.println("---------------------");
        }

        System.out.println();
        Arrays.sort(students, Comparator.comparing(Student::getSemester).thenComparing(Student::getCGPA));
        System.out.println("Students sorted by semester and cgpa: ");
        Student.display(students);

        char ch = 'J';
        System.out.println("\nStudents whose name starts with the given character: ");
        Student.liststudents(students, ch);

        String sub = "mith";
        System.out.println("\nStudents containing the substring are: ");
        Student.substring(students, sub);

        for (Student student : students) {
            student.modifyname();
        }
        System.out.println("\nStudents with names modified to initials: ");
        Student.display(students);
    }
}
