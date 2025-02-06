// Auto-generated file
public class module1_1_08 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Input number: ");
        int n = scanner.nextInt();
        
        // Calculate nn and nnn
        int nn = n * 11;  // This creates nn (like 55 for n=5)
        int nnn = n * 111; // This creates nnn (like 555 for n=5)
        
        int sum = n + nn + nnn;
        
        System.out.println(n + " + " + nn + " + " + nnn);
        System.out.println("The sum is: " + sum);
        
        scanner.close();
    }
}
