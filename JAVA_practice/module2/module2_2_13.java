// Auto-generated file
public class module2_2_13 {
    public static void printNumChar(int n, char c) {
        System.out.println("Number: " + n + ", Character: " + c);
    }

    public static void printNumChar(char c, int n) {
        System.out.println("Character: " + c + ", Number: " + n); 
    }

    public static void main(String[] args) {
        // Test first method (int, char)
        printNumChar(42, 'A');
        
        // Test second method (char, int) 
        printNumChar('B', 100);
    }
}
