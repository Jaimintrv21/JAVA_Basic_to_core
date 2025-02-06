// Auto-generated file
public class module1_1_06 {
    public static void main(String[] args) {
        String test = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
        count(test);
    }
    
    public static void count(String str) {
        int letters = 0;
        int spaces = 0;
        int numbers = 0;
        int others = 0;
        
        char[] chars = str.toCharArray();
        
        for(char c : chars) {
            if(Character.isLetter(c)) {
                letters++;
            }
            else if(Character.isSpaceChar(c)) {
                spaces++;
            }
            else if(Character.isDigit(c)) {
                numbers++;
            }
            else {
                others++;
            }
        }
        
        System.out.println("The string is: " + str);
        System.out.println("Letters: " + letters);
        System.out.println("Spaces: " + spaces);
        System.out.println("Numbers: " + numbers);
        System.out.println("Other characters: " + others);
    }
}
