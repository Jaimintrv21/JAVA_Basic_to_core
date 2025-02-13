import java.util.ArrayList;

public class module2_2_37 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        list.add("Element 4");
        list.add("Element 5");

        System.out.println("Original list: " + list);

        // Remove the third element (index 2)
        if (list.size() >= 3) {
            list.remove(2);
        }

        System.out.println("List after removing the third element: " + list);
    }
}
