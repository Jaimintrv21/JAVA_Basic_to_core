import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    // Database credentials - replace these with your actual values
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

          
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");

            
            Statement stmt = conn.createStatement();

            // SQL for creating EMP table
            String createEmpTable = "CREATE TABLE IF NOT EXISTS EMP (" +
                "Empno INT(4) NOT NULL PRIMARY KEY," +
                "Ename VARCHAR(10)," +
                "Job VARCHAR(9)," +
                "Mgr INT(4)," +
                "Hiredate DATE," +
                "Sal DECIMAL(7,2)," +
                "Comm DECIMAL(7,2)," +
                "Deptno INT(2)," +
                "DEFAULT 0," +
                "FOREIGN KEY (Deptno) REFERENCES DEPT(Deptno)" +
                ")";

            String createDeptTable = "CREATE TABLE IF NOT EXISTS DEPT (" +
                "Deptno INT(2) NOT NULL PRIMARY KEY," +
                "Dname VARCHAR(14)," +
                "Loc VARCHAR(13)," +
                "DEFAULT 0" +
                ")";

            
            System.out.println("Creating DEPT table...");
            stmt.executeUpdate(createDeptTable);
            System.out.println("DEPT table created successfully!");

          
            System.out.println("Creating EMP table...");
            stmt.executeUpdate(createEmpTable);
            System.out.println("EMP table created successfully!");

            stmt.close();
            conn.close();
            System.out.println("Resources closed successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}