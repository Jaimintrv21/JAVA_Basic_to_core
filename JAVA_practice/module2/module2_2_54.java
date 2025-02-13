import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class module2_2_54 {
    public static void main(String[] args) {
        // Create a HashMap and add some key-value pairs
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Get a collection view of the values contained in the map
        Collection<Integer> values = map.values();

        // Print the values
        System.out.println("Values in the map: " + values);
    }
}
