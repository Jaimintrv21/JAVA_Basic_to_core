// Auto-generated file
public class module2_2_14 {
    public static void printArea(int length, int breadth) {
        int area = length * breadth;
        System.out.println("Area of rectangle with length " + length + " and breadth " + breadth + " is: " + area);
    }

    public static void printArea(int side) {
        int area = side * side;
        System.out.println("Area of square with side " + side + " is: " + area);
    }

    public static void main(String[] args) {
        // Test rectangle area calculation
        printArea(5, 3);
        
        // Test square area calculation
        printArea(4);
    }
}
