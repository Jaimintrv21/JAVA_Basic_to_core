// Auto-generated file
public class module2_2_24 {
    // Custom exception class for insufficient balance
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    // Method to validate voting age
    public static void validateAge(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("not valid");
        } else {
            System.out.println("Welcome to vote!");
        }
    }

    // Method to process withdrawal
    public static void withdrawAmount(double balance, double withdrawAmount) throws InsufficientBalanceException {
        if (withdrawAmount > balance) {
            double needed = withdrawAmount - balance;
            throw new InsufficientBalanceException("Sorry, insufficient balance, you need more " + needed + " Rs. To perform this transaction.");
        }
        balance -= withdrawAmount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public static void main(String[] args) {
        // Testing age validation
        try {
            System.out.println("Enter your age: 16");
            validateAge(16);
        } catch (ArithmeticException e) {
            System.out.println("Exception in thread main java.lang.ArithmeticException: " + e.getMessage());
        }

        // Testing bank withdrawal
        try {
            double accountBalance = 2000;
            System.out.println("Account balance is: " + accountBalance);
            System.out.println("Enter withdraw amount: 2500");
            withdrawAmount(accountBalance, 2500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
