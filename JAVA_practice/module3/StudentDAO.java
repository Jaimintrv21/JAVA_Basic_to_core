// Student.java - Model class
public class Student {
    private int rno;
    private String sname;
    private String city;
    private String state;

    // Constructors
    public Student() {}

    public Student(int rno, String sname, String city, String state) {
        this.rno = rno;
        this.sname = sname;
        this.city = city;
        this.state = state;
    }

    // Getters and Setters
    public int getRno() { return rno; }
    public void setRno(int rno) { this.rno = rno; }
    
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}

// StudentDAO.java - Database operations
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Create table
    public void createTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            String sql = "CREATE TABLE IF NOT EXISTS STUDENT (" +
                        "Rno INT(2) NOT NULL PRIMARY KEY DEFAULT 0," +
                        "Sname VARCHAR(14) DEFAULT NULL," +
                        "City VARCHAR(20) DEFAULT NULL," +
                        "State VARCHAR(20) DEFAULT NULL" +
                        ")";
            
            stmt.executeUpdate(sql);
            System.out.println("Student table created successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert student
    public void insertStudent(Student student) {
        String sql = "INSERT INTO STUDENT (Rno, Sname, City, State) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, student.getRno());
            pstmt.setString(2, student.getSname());
            pstmt.setString(3, student.getCity());
            pstmt.setString(4, student.getState());
            
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("Rno"),
                    rs.getString("Sname"),
                    rs.getString("City"),
                    rs.getString("State")
                );
                students.add(student);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return students;
    }

    // Update student
    public void updateStudent(Student student) {
        String sql = "UPDATE STUDENT SET Sname = ?, City = ?, State = ? WHERE Rno = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getSname());
            pstmt.setString(2, student.getCity());
            pstmt.setString(3, student.getState());
            pstmt.setInt(4, student.getRno());
            
            pstmt.executeUpdate();
            System.out.println("Student updated successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int rno) {
        String sql = "DELETE FROM STUDENT WHERE Rno = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, rno);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        
        // Create table
        dao.createTable();
        
        // Test insert
        Student student = new Student(1, "John Doe", "New York", "NY");
        dao.insertStudent(student);
        
        // Test get all students
        List<Student> students = dao.getAllStudents();
        for (Student s : students) {
            System.out.println("Student: " + s.getSname() + ", City: " + s.getCity());
        }
    }
}