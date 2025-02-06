// Auto-generated file
public class module1_1_05 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Input an integer number less than ten billion: ");
        long number = scanner.nextLong();
        
        if (number < 0) {
            number = -number;
        }
        
        int count = 0;
        
        if (number == 0) {
            count = 1;
        } else {
            while (number > 0) {
                count++;
                number = number / 10;
            }
        }
        
        System.out.println("Number of digits in the number: " + count);
        
        scanner.close();
    }
}
