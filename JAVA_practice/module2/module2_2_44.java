import java.util.HashMap;
import java.util.Map;

public class module2_2_44 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashList = new HashMap<>();
        hashList.put("One", 1);
        hashList.put("Two", 2);
        hashList.put("Three", 3);

        // Iterate through all elements in the hash list
        for (Map.Entry<String, Integer> entry : hashList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
