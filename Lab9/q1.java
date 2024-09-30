class MultiplicationTableThread extends Thread {
    private int number;
    public MultiplicationTableThread(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Multiplication Table for " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Finished printing multiplication table for " + number);
    }
}

public class q1 {
    public static void main(String[] args) {
        MultiplicationTableThread tableOf5 = new MultiplicationTableThread(5);
        MultiplicationTableThread tableOf7 = new MultiplicationTableThread(7);
        tableOf5.start();
        tableOf7.start();
        try {
            tableOf5.join();
            tableOf7.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Both multiplication tables have been printed.");
    }
}
