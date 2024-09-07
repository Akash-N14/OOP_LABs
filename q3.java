import java.util.Scanner;

class Person {
    private String name;
    private String birthDate;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

class CollegeGraduate extends Person {
    private double gpa;
    private int yearOfGraduation;

    public CollegeGraduate(String name, String birthDate, double gpa, int yearOfGraduation) {
        super(name, birthDate);
        this.gpa = gpa;
        this.yearOfGraduation = yearOfGraduation;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the person's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the person's birth date (YYYY-MM-DD):");
        String birthDate = scanner.nextLine();

        System.out.println("Enter the GPA of the graduate:");
        double gpa = scanner.nextDouble();
        System.out.println("Enter the year of graduation:");
        int yearOfGraduation = scanner.nextInt();

        CollegeGraduate graduate = new CollegeGraduate(name, birthDate, gpa, yearOfGraduation);

        System.out.println("\nCollege Graduate Details:");
        System.out.println("Name: " + graduate.getName());
        System.out.println("Birth Date: " + graduate.getBirthDate());
        System.out.println("GPA: " + graduate.getGpa());
        System.out.println("Year of Graduation: " + graduate.getYearOfGraduation());
        scanner.close();
    }
}