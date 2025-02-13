import java.util.ArrayList;

public class module2_2_35 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        int index = 1; // Specify the index you want to retrieve
        if (index >= 0 && index < list.size()) {
            String element = list.get(index);
            System.out.println("Element at index " + index + ": " + element);
        } else {
            System.out.println("Index out of bounds");
        }
    }
}
