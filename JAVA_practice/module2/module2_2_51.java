import java.util.ArrayList;

public class module2_2_51 {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        // Print the original list
        System.out.println("Original list: " + list);

        // Increase the size of the ArrayList by adding more elements
        list.add("Element 4");
        list.add("Element 5");

        // Replace the second element
        list.set(1, "New Element 2");

        // Print the modified list
        System.out.println("Modified list: " + list);
    }
}
