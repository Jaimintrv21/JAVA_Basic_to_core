// Auto-generated file
public class module2_2_5 {
    public static void findInterleavings(String str1, String str2, String result, java.util.Set<String> interleavings) {
 
        if (str1.length() == 0 && str2.length() == 0) {
            interleavings.add(result);
            return;
        }
        
 
        if (str1.length() > 0) {
            findInterleavings(str1.substring(1), str2, result + str1.charAt(0), interleavings);
        }
        
      
        if (str2.length() > 0) {
            findInterleavings(str1, str2.substring(1), result + str2.charAt(0), interleavings);
        }
    }

    public static void main(String[] args) {
        String str1 = "WX";
        String str2 = "YZ";
        
        java.util.Set<String> interleavings = new java.util.TreeSet<>();
        findInterleavings(str1, str2, "", interleavings);
        
        System.out.println("The given strings are: " + str1 + " " + str2);
        System.out.print("The interleaving strings are: ");
        System.out.println(String.join(" ", interleavings));
    }
}
