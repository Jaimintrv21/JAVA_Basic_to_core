import java.util.ArrayList;
import java.util.Collections;

public class module2_2_42 {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");
        items.add("Elderberry");

        System.out.println("Original list: " + items);
        Collections.shuffle(items);
        System.out.println("Shuffled list: " + items);
    }
}
