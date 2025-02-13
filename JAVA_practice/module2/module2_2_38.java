import java.util.ArrayList;
import java.util.Scanner;

public class module2_2_38 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an element to search: ");
        String element = scanner.nextLine();

        if (list.contains(element)) {
            System.out.println(element + " is found in the list.");
        } else {
            System.out.println(element + " is not found in the list.");
        }
        scanner.close();
    }
}
