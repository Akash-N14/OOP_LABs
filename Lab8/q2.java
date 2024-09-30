import java.util.Scanner;

// Custom Exception for Invalid Day
class InvalidDayException extends Exception {
    public InvalidDayException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Month
class InvalidMonthException extends Exception {
    public InvalidMonthException(String message) {
        super(message);
    }
}

// Class to represent a date
class CurrentDate {
    private int day;
    private int month;
    private int year;

    // Method to create a date by reading from keyboard
    public void createDate() throws InvalidDayException, InvalidMonthException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day: ");
        day = scanner.nextInt();

        System.out.print("Enter month: ");
        month = scanner.nextInt();

        System.out.print("Enter year: ");
        year = scanner.nextInt();

        // Validate month
        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Invalid month: " + month);
        }

        // Validate day based on the month
        if (day < 1 || day > daysInMonth(month, year)) {
            throw new InvalidDayException("Invalid day: " + day);
        }

        // Display the valid date
        System.out.println("Current Date: " + this);
    }

    // Helper method to calculate the number of days in a month
    private int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                // Check for leap year
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    // Override toString() to print the date in a readable format
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

// Test program
public class q2 {
    public static void main(String[] args) {
        CurrentDate currentDate = new CurrentDate();
        
        try {
            currentDate.createDate();
        } catch (InvalidDayException | InvalidMonthException e) {
            System.out.println(e.getMessage());
        }
    }
}
