// Auto-generated file
public class module1_1_01 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Part 1: Check if input year is leap year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        if (isLeapYear) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }

        // Part 2: Display first 10 natural numbers
        System.out.println("\nFirst 10 natural numbers:");
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        scanner.close();
    }
}
