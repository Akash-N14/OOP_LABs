import mypackages.p1.Maximum;
import java.util.Scanner;

public class q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Maximum obj = new Maximum();
            
        System.out.print("Enter 3 integer ");
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int c1 = sc.nextInt();
        int ans1 = obj.max(a1, b1, c1);
        System.out.println("MAX is: " + ans1);

        System.out.print("Enter 3 float ");
        float a2 = sc.nextFloat();
        float b2 = sc.nextFloat();
        float c2 = sc.nextFloat();
        float ans2 = obj.max(a2, b2, c2);
        System.out.println("MAX is: " + ans2);

        int arr[] = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        int ans3 = obj.max(arr);
        System.out.println("MAX is: " + ans3);

        int mat[][] = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int ans4 = obj.max(mat);
        System.out.println("MAX is: " + ans4);

        sc.close();
    }
}
