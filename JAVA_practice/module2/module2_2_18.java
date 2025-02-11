// Auto-generated file
class Triangle {
    private double side1 = 3;
    private double side2 = 4; 
    private double side3 = 5;
    
    public double getArea() {
        // Using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

public class module2_2_18 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
    }
}
