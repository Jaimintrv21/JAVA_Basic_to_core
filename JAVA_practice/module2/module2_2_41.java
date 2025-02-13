import java.util.ArrayList;

public class module2_2_41 {
    public static void main(String[] args) {
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        ArrayList<String> copiedList = new ArrayList<>(originalList);

        System.out.println("Original List: " + originalList);
        System.out.println("Copied List: " + copiedList);
    }
}
