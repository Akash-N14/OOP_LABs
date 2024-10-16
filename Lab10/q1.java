import java.util.Arrays;

public class q1 {

    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length) {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } else {
            System.out.println("Invalid indices");
        }
    }

    public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swapping: " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("After swapping: " + Arrays.toString(intArray));

        // Example with String array
        String[] strArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Before swapping: " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("After swapping: " + Arrays.toString(strArray));
    }
}
