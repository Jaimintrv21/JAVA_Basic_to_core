
public class module1_1_0 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Enter three numbers:");
        
        System.out.print("First number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.print("Third number: ");
        double num3 = scanner.nextDouble();
        
        double greatest = num1;
        
        if (num2 > greatest) {
            greatest = num2;
        }
        
        if (num3 > greatest) {
            greatest = num3;
        }
        
        System.out.println("The greatest number is: " + greatest);
        
        scanner.close();
    }
}
