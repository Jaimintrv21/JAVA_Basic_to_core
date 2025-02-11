// Auto-generated file
public class PrintNumber {
    public static void printn(int number) {
        System.out.println("Integer number: " + number);
    }

    public static void printn(double number) {
        System.out.println("Double number: " + number);
    }

    public static void printn(float number) {
        System.out.println("Float number: " + number);
    }

    public static void printn(long number) {
        System.out.println("Long number: " + number);
    }

    public static void printn(short number) {
        System.out.println("Short number: " + number);
    }

    public static void printn(byte number) {
        System.out.println("Byte number: " + number);
    }

    public static void main(String[] args) {
        printn(10);            // int
        printn(10.5);         // double
        printn(10.5f);        // float
        printn(1000000000L);  // long
        printn((short)100);   // short
        printn((byte)5);      // byte
    }
}
