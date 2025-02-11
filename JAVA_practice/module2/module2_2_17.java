// Auto-generated file
class Rectangle {
    protected double length;
    protected double breadth;
    
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    
    public void printArea() {
        double area = length * breadth;
        System.out.println("Area of rectangle: " + area);
    }
    
    public void printPerimeter() {
        double perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of rectangle: " + perimeter);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

public class module2_2_17 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Rectangle:");
        rect.printArea();
        rect.printPerimeter();
        
        Square square = new Square(4);
        System.out.println("\nSquare:");
        square.printArea();
        square.printPerimeter();
    }
}
