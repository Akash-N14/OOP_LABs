import java.util.Scanner;

class InvalidDayException extends Exception {
    public InvalidDayException(String message) {
        super(message);
    }
}

class InvalidMonthException extends Exception {
    public InvalidMonthException(String message) {
        super(message);
    }
}

class CurrentDate {
    private int day;
    private int month;
    private int year;

    public void createDate() throws InvalidDayException, InvalidMonthException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day: ");
        day = scanner.nextInt();

        System.out.print("Enter month: ");
        month = scanner.nextInt();

        System.out.print("Enter year: ");
        year = scanner.nextInt();

        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Invalid month: " + month);
        }

        if (day < 1 || day > daysInMonth(month, year)) {
            throw new InvalidDayException("Invalid day: " + day);
        }

        System.out.println("Current Date: " + this);
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
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

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

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
