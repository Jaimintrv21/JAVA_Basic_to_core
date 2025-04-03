import java.util.regex.*;

public class FormValidator {
    public static void main(String[] args) {
        // Example inputs for validation
        String firstName = "John";
        String lastName = "Doe";
        String mobile = "1234567890";
        String email = "john.doe@example.com";
        String password = "Password@123";

        // Validate inputs
        if (validateFirstName(firstName) && validateLastName(lastName) && validateMobile(mobile) && validateEmail(email) && validatePassword(password)) {
            System.out.println("All inputs are valid.");
        } else {
            System.out.println("Some inputs are invalid.");
        }
    }

    public static boolean validateFirstName(String firstName) {
        return firstName.matches("[a-zA-Z]+");
    }

    public static boolean validateLastName(String lastName) {
        return lastName.matches("[a-zA-Z]+");
    }

    public static boolean validateMobile(String mobile) {
        return mobile.matches("\\d{10}");
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static boolean validatePassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&_])[A-Za-z\\d@#$%&_]{8,}$";
        return password.matches(passwordRegex);
    }
}
