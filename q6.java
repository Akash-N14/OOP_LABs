import java.util.Scanner;

class NumberFormatter
{
    String number;
    String formattednum = " ";

    NumberFormatter(String number)
    {
        this.number = number;
    }

    void addCommas()
    {
        int length = number.length();
        int comma = length % 3;
        for (int i = 0; i < length; i++) {
            formattednum += number.charAt(i);
            if ((i + 1) % 3 == comma && i != length - 1) {
                formattednum += ",";
            }
        }
    }

    void display()
    {
        System.out.println("Formatted number: "+formattednum);
    }
}

public class q6
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String num = sc.nextLine();
        NumberFormatter nf = new NumberFormatter(num);
        nf.addCommas();
        nf.display();
        sc.close();
    }
}