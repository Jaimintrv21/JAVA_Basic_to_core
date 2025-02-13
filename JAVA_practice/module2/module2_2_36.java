import java.util.Scanner;

public class module2_2_36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Sample array
        int[] array = {10, 20, 30, 40, 50};
        
        System.out.println("Original array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Input index and new value
        System.out.print("Enter the index of the element to update (0-4): ");
        int index = scanner.nextInt();
        System.out.print("Enter the new value: ");
        int newValue = scanner.nextInt();
        
        // Update the array element
        if (index >= 0 && index < array.length) {
            array[index] = newValue;
            System.out.println("Updated array: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Index out of bounds.");
        }
        
        scanner.close();
    }
}
