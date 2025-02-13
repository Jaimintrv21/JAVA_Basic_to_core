// Auto-generated file
public class module2_2_23 {
    public static void main(String[] args) {
        try {
            // Check if exactly two arguments are provided
            if (args.length != 2) {
                throw new IllegalArgumentException("Please provide exactly two numbers as command line arguments");
            }

            // Parse the command line arguments to integers
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            // Perform division
            int result = num1 / num2;
            System.out.println("Result of " + num1 + " / " + num2 + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integer numbers");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
