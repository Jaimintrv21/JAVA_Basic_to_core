// Auto-generated file
public class module2_2_22 {
    public static void main(String[] args) {
        try {
            try {
                // Demonstrating nested try-catch blocks
                int[] arr = new int[5];
                arr[10] = 50; // This will throw ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch block 1: " + e.getMessage());
                int num = Integer.parseInt("abc"); // This will throw NumberFormatException
            }
        } catch (NumberFormatException e) {
            System.out.println("Outer catch block: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception caught: " + e.getMessage());
        }
    }
}
