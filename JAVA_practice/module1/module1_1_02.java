// Auto-generated file
public class module1_1_02 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        int sum = 0;
        System.out.println("Enter 5 numbers:");
        
        for (int i = 1; i <= 5; i++) {
            System.out.print("Number " + i + ": ");
            int num = scanner.nextInt();
            sum += num;
        }
        
        double average = (double) sum / 5;
        
        System.out.println("Sum of the numbers: " + sum);
        System.out.println("Average of the numbers: " + average);
        
        scanner.close();
    }
}
