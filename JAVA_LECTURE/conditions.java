public class conditions{
public class conditions {
    public static void main(String[] args) {
        // if condition
        int x = 10;
        if (x > 5) {
            System.out.println("x is greater than 5");
        }

        // if-else condition
        int y = 15;
        if (y > 10) {
            System.out.println("y is greater than 10");
        } else {
            System.out.println("y is less than or equal to 10");
        }

        // else-if condition
        int z = 20;
        if (z > 25) {
            System.out.println("z is greater than 25");
        } else if (z > 15) {
            System.out.println("z is greater than 15 but less than or equal to 25");
        } else {
            System.out.println("z is less than or equal to 15");
        }

        // nested if-else condition
        int a = 30;
        int b = 20;
        if (a > 25) {
            if (b > 15) {
                System.out.println("a is greater than 25 and b is greater than 15");
            } else {
                System.out.println("a is greater than 25 but b is less than or equal to 15");
            }
        } else {
            System.out.println("a is less than or equal to 25");
        }
    }
}
}