import java.util.ArrayList;
import java.util.Collections;

public class module2_2_48 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        System.out.println("Original list: " + list);
        
        Collections.reverse(list);
        
        System.out.println("Reversed list: " + list);
    }
}
