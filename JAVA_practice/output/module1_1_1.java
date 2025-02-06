// Auto-generated file
public class module1_1_1 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Enter a single character from the alphabet: ");
        String input = scanner.nextLine();
        
        if (input.length() != 1) {
            System.out.println("Error: Please enter a single character.");
        } else {
            char ch = input.charAt(0);
            
            if (!Character.isLetter(ch)) {
                System.out.println("Error: Please enter a letter from the alphabet.");
            } else {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    System.out.println("Vowel");
                } else {
                    System.out.println("Consonant"); 
                }
            }
        }
        
        scanner.close();
    }
}
