import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class module2_2_55 {
    public static void main(String[] args) {
        // Create a HashSet and add some elements
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        hashSet.add("Element 3");

        // Convert HashSet to ArrayList
        List<String> list = new ArrayList<>(hashSet);

        // Print the ArrayList
        System.out.println("ArrayList converted from HashSet: " + list);
    }
}
