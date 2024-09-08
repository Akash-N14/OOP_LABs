import java.util.Scanner;

class Student
{
    String sname, initial = " ";
    String wname = " ";

    Student(String sname)
    {
        this.sname = sname;
    }

    void extractInitials()
    {
        if (sname.length() > 0) {
            initial += Character.toUpperCase(sname.charAt(0));
            for (int i = 1; i < sname.length(); i++) {
                if (sname.charAt(i - 1) == ' ') {
                    initial += sname.charAt(i);
                }
            }
        }
    }

    void removeWhitespace()
    {
        wname = sname.replaceAll("\\s", "");
    }

    void substring(String sub)
    {
        if (sname.contains(sub)) {
            display();
        }
    }

    static void sort(Student[] s,int n)
    {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s[i].sname.compareTo(s[j].sname) > 0) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
    }

    void display()
    {
        System.out.println("Student name: "   + sname);
        System.out.println("Initials: " + initial);
        System.out.println("Name without whitespace: "   + wname);
    }
}

public class q2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] s1 = new Student[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String sname = sc.nextLine();
            s1[i] = new Student(sname);
            s1[i].extractInitials();
            s1[i].removeWhitespace();
        }
        System.out.print("Enter substring to search: ");
        String sub = sc.nextLine();
        System.out.println("Students with names containing the substring:");
        for(int i=0;i<n;i++)
        {
            s1[i].substring(sub);
        }
        Student.sort(s1, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            s1[i].display();
            System.out.println();
        }
        sc.close();
    }
}