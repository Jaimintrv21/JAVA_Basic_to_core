import java.util.HashSet;
import java.util.Set;

public class module2_2_53 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Adding elements to the first set
        set1.add("Apple");
        set1.add("Banana");
        set1.add("Cherry");

        // Adding elements to the second set
        set2.add("Banana");
        set2.add("Cherry");
        set2.add("Date");

        // Retaining only the elements that are the same in both sets
        set1.retainAll(set2);

        // Displaying the common elements
        System.out.println("Common elements in both sets: " + set1);
    }
}
