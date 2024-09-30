import java.util.Scanner;

class RowSum implements Runnable {
    private int[] row;
    private int rowIndex;
    private static int totalSum = 0;

    public RowSum(int[] row, int rowIndex) {
        this.row = row;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        int rowSum = 0;
        for (int num : row) {
            rowSum += num;
        }
        System.out.println("Row " + rowIndex + " sum = " + rowSum);
        addToTotalSum(rowSum);
    }

    private static void addToTotalSum(int rowSum) {
        totalSum += rowSum;
    }
    public static int getTotalSum() {
        return totalSum;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        Thread[] threads = new Thread[rows];
        for (int i = 0; i < rows; i++) {
            threads[i] = new Thread(new RowSum(matrix[i], i));
            threads[i].start();
        }
        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Total sum of matrix = " + RowSum.getTotalSum());
        scanner.close();
    }
}
