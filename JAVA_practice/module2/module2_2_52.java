import java.util.ArrayList;

public class module2_2_52 {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        list.add("Element 4");

        // Print all elements using their positions
        System.out.println("Elements in the ArrayList:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at position " + i + ": " + list.get(i));
        }
    }
}
