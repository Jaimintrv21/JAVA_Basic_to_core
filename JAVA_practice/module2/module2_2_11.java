// Auto-generated file
public class module2_2_11 {
    public static void main(String[] args) {
        String str = "successes";
        
        // Create array to store character frequencies
        int[] freq = new int[256];
        
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        
        // Find highest and second highest frequencies
        int max = 0, secondMax = 0;
        char maxChar = '\0', secondMaxChar = '\0';
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] > freq[max]) {
                secondMax = max;
                max = i;
            } else if (freq[i] > freq[secondMax] && freq[i] != freq[max]) {
                secondMax = i;
            }
        }
        
        System.out.println("The given string is: " + str);
        System.out.println("The second most frequent char in the string is: " + (char)secondMax);
    }
}
