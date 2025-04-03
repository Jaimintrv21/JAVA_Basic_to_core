// Auto-generated file
import java.util.regex.*;

public class module4_1_14 {
    public static void main(String[] args) {
        String password = "Test@123"; // Example password for validation
        if (validatePassword(password)) {
            System.out.println("Hello from module4_1_14! Password is valid.");
        } else {
            System.out.println("Hello from module4_1_14! Password is invalid.");
        }
    }

    private static boolean validatePassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&_])[A-Za-z\\d@#$%&_]{8,}$";
        return password.matches(passwordRegex);
    }
}
