import java.util.HashMap;
import java.util.Map;

public class Module2_2_47 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        int size = map.size();
        System.out.println("The number of key-value mappings in the map is: " + size);
    }
}
