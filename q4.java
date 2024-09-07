import java.util.Scanner;

class Building {
    private double squareFootage;
    private int stories;

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getStories() {
        return stories;
    }

    public void setStories(int stories) {
        this.stories = stories;
    }
}

class House extends Building {
    private int numberOfBedrooms;
    private int numberOfBaths;

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBaths() {
        return numberOfBaths;
    }

    public void setNumberOfBaths(int numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }
}

class School extends Building {
    private int numberOfClassrooms;
    private String gradeLevel;

    public int getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

    public void setNumberOfClassrooms(int numberOfClassrooms) {
        this.numberOfClassrooms = numberOfClassrooms;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        House house = new House();
        System.out.print("Enter house square footage: ");
        house.setSquareFootage(scanner.nextDouble());
        System.out.print("Enter house stories: ");
        house.setStories(scanner.nextInt());
        System.out.print("Enter number of bedrooms: ");
        house.setNumberOfBedrooms(scanner.nextInt());
        System.out.print("Enter number of baths: ");
        house.setNumberOfBaths(scanner.nextInt());

        School school = new School();
        System.out.print("Enter school square footage: ");
        school.setSquareFootage(scanner.nextDouble());
        System.out.print("Enter school stories: ");
        school.setStories(scanner.nextInt());
        System.out.print("Enter number of classrooms: ");
        school.setNumberOfClassrooms(scanner.nextInt());
        System.out.print("Enter grade level: ");
        scanner.nextLine();
        school.setGradeLevel(scanner.nextLine());

        System.out.println("House: ");
        System.out.println("Square Footage: " + house.getSquareFootage());
        System.out.println("Stories: " + house.getStories());
        System.out.println("Bedrooms: " + house.getNumberOfBedrooms());
        System.out.println("Baths: " + house.getNumberOfBaths());

        System.out.println("School: ");
        System.out.println("Square Footage: " + school.getSquareFootage());
        System.out.println("Stories: " + school.getStories());
        System.out.println("Classrooms: " + school.getNumberOfClassrooms());
        System.out.println("Grade Level: " + school.getGradeLevel());

        scanner.close();
    }
}