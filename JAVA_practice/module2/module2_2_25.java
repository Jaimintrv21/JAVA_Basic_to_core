// Auto-generated file
// Custom exception for invalid age range
class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

// Custom exception for invalid name
class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

// Student class
class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
        // Validate age
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age must be between 15 and 21");
        }

        // Validate name
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            throw new NameNotValidException("Name can only contain letters and spaces");
        }

        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", course=" + course + "]";
    }
}

public class module2_2_25 {
    public static void main(String[] args) {
        try {
            // Valid student
            Student student1 = new Student(1, "John Doe", 18, "Computer Science");
            System.out.println(student1);

            // Invalid age
            Student student2 = new Student(2, "Jane Smith", 14, "Physics");
        } catch (AgeNotWithinRangeException e) {
            System.out.println("Age Error: " + e.getMessage());
        } catch (NameNotValidException e) {
            System.out.println("Name Error: " + e.getMessage());
        }

        try {
            // Invalid name
            Student student3 = new Student(3, "Tom123", 19, "Mathematics");
        } catch (AgeNotWithinRangeException e) {
            System.out.println("Age Error: " + e.getMessage());
        } catch (NameNotValidException e) {
            System.out.println("Name Error: " + e.getMessage());
        }
    }
}
