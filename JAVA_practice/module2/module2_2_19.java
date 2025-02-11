// Auto-generated file
class Complex {
    private double real;
    private double imag;
    
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }
    
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }
    
    public Complex multiply(Complex other) {
        double resultReal = (this.real * other.real) - (this.imag * other.imag);
        double resultImag = (this.real * other.imag) + (this.imag * other.real);
        return new Complex(resultReal, resultImag);
    }
    
    public String toString() {
        if (imag >= 0) {
            return real + " + " + imag + "i";
        } else {
            return real + " - " + (-imag) + "i";
        }
    }
}

public class module2_2_19 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Enter first complex number:");
        System.out.print("Real part: ");
        double real1 = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double imag1 = scanner.nextDouble();
        
        System.out.println("\nEnter second complex number:");
        System.out.print("Real part: ");
        double real2 = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double imag2 = scanner.nextDouble();
        
        Complex num1 = new Complex(real1, imag1);
        Complex num2 = new Complex(real2, imag2);
        
        System.out.println("\nSum: " + num1.add(num2));
        System.out.println("Difference: " + num1.subtract(num2));
        System.out.println("Product: " + num1.multiply(num2));
        
        scanner.close();
    }
}
