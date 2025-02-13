import java.util.ArrayList;
import java.util.Collections;

public class module2_2_39 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        list.add("Date");

        System.out.println("Original list: " + list);
        
        Collections.sort(list);
        
        System.out.println("Sorted list: " + list);
    }
}
