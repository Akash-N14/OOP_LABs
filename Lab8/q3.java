import java.util.Scanner;
import java.util.GregorianCalendar;

class SeatsFilledExc extends Exception {
    String err;

    SeatsFilledExc() {
        err = "SeatsFilledException";
    }

    String getCode() {
        return err;
    }
}

class Student {
    int regno;
    String fName;
    GregorianCalendar DOJ;
    static int count = 1;

    Student() {
        count += 1;
    }

    Student(String name, int d, int m, int y) throws SeatsFilledExc {
        SeatsFilledExc sfe = new SeatsFilledExc();
        if (count >= 25) {
            throw sfe;
        }
        GregorianCalendar gcal = new GregorianCalendar(y, m-1, d);
        regno = (y % 100) * 100 + count;
        fName = name;
        DOJ = gcal;
        count += 1;
    }

    void display() {
        System.out.println("\nName of student: " + fName + "\nRegistration Number: " + regno + "\nDate of joining: "
                + DOJ.get(5) + "/" + DOJ.get(2) + "/" + DOJ.get(1));
    }
}

class q3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student stds[] = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Enter your name: ");
            String fName = sc.nextLine();
            System.out.print("Enter day of  Joining: ");
            int d = sc.nextInt();
            System.out.print("Enter month of Joining: ");
            int m = sc.nextInt();
            System.out.print("Enter year of Joining: ");
            int y = sc.nextInt();
            sc.nextLine();
            try {
                stds[i] = new Student(fName, d, m, y);
            } catch (SeatsFilledExc e) {
                System.out.println("Exception Thrown: " + e.getCode());
            }
        }

        System.out.println("\nDisplaying details of all students:\n");
        for (int i = 0; i < n; i++) {
            System.out.println("\nstudent " + (i + 1));
            stds[i].display();
        }
        sc.close();
    }
}