import java.util.HashSet;

public class module2_2_43 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        
        // Append specified element
        String elementToAdd = "Element 3";
        hashSet.add(elementToAdd);
        
        System.out.println("HashSet after adding element: " + hashSet);
    }
}
