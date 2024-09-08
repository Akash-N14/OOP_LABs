import java.util.Scanner;
import java.lang.String;

class Employee {
    String name;

    Employee(String name)
    {
        this.name = name;
    }

    public String formatEmployee()
    {
        String[] parts = name.toLowerCase().split(" ");
        StringBuilder formattedname = new StringBuilder();
        for (String part : parts) {
            if (part.length() > 0) {
                formattedname.append(part.toUpperCase().charAt(0)).append(part.substring(1)).append(" ");
            }
        }
        return formattedname.toString();
    }

    public String generateEmail()
    {
        String[] parts = name.toLowerCase().split(" ");
        return parts[0].charAt(0) + parts[parts.length - 1] + "@example.com";
    }
}
public class q1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee name: ");
        String ename = sc.nextLine();
        Employee e = new Employee(ename);
        System.out.println("Initials: " + e.formatEmployee());
        System.out.println("Email: " + e.generateEmail());
        sc.close();
    }
}