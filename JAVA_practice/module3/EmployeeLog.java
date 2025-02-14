// EmployeeLog.java - Model class
public class EmployeeLog {
    private int empId;
    private Date logDate;
    private int newSalary;
    private String action;
    
    // Constructors
    public EmployeeLog() {}
    
    public EmployeeLog(int empId, Date logDate, int newSalary, String action) {
        this.empId = empId;
        this.logDate = logDate;
        this.newSalary = newSalary;
        this.action = action;
    }
    
    // Getters and Setters
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    
    public Date getLogDate() { return logDate; }
    public void setLogDate(Date logDate) { this.logDate = logDate; }
    
    public int getNewSalary() { return newSalary; }
    public void setNewSalary(int newSalary) { this.newSalary = newSalary; }
    
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
}

// EmployeeLogDAO.java - Database operations
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLogDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Create table
    public void createTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            String sql = "CREATE TABLE IF NOT EXISTS EMP_LOG (" +
                        "Emp_id INT(5) NOT NULL," +
                        "Log_date DATE DEFAULT NULL," +
                        "New_salary INT(10) DEFAULT NULL," +
                        "Action VARCHAR(20) DEFAULT NULL" +
                        ")";
            
            stmt.executeUpdate(sql);
            System.out.println("EMP_LOG table created successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert log entry
    public void insertLog(EmployeeLog log) {
        String sql = "INSERT INTO EMP_LOG (Emp_id, Log_date, New_salary, Action) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, log.getEmpId());
            pstmt.setDate(2, new java.sql.Date(log.getLogDate().getTime()));
            pstmt.setInt(3, log.getNewSalary());
            pstmt.setString(4, log.getAction());
            
            pstmt.executeUpdate();
            System.out.println("Log entry inserted successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get logs by employee ID
    public List<EmployeeLog> getLogsByEmployee(int empId) {
        List<EmployeeLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM EMP_LOG WHERE Emp_id = ? ORDER BY Log_date DESC";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, empId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                EmployeeLog log = new EmployeeLog(
                    rs.getInt("Emp_id"),
                    rs.getDate("Log_date"),
                    rs.getInt("New_salary"),
                    rs.getString("Action")
                );
                logs.add(log);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return logs;
    }

    // Get logs by date range
    public List<EmployeeLog> getLogsByDateRange(Date startDate, Date endDate) {
        List<EmployeeLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM EMP_LOG WHERE Log_date BETWEEN ? AND ? ORDER BY Log_date DESC";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                EmployeeLog log = new EmployeeLog(
                    rs.getInt("Emp_id"),
                    rs.getDate("Log_date"),
                    rs.getInt("New_salary"),
                    rs.getString("Action")
                );
                logs.add(log);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return logs;
    }

    // Create trigger for salary changes
    public void createSalaryTrigger() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            String sql = "CREATE TRIGGER emp_salary_log " +
                        "AFTER UPDATE ON EMP " +
                        "FOR EACH ROW " +
                        "BEGIN " +
                        "  IF NEW.Sal <> OLD.Sal THEN " +
                        "    INSERT INTO EMP_LOG (Emp_id, Log_date, New_salary, Action) " +
                        "    VALUES (NEW.Empno, CURDATE(), NEW.Sal, 'SALARY_UPDATE'); " +
                        "  END IF; " +
                        "END;";
            
            stmt.executeUpdate(sql);
            System.out.println("Salary trigger created successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        EmployeeLogDAO dao = new EmployeeLogDAO();
        
        // Create table
        dao.createTable();
        
        // Create trigger
        dao.createSalaryTrigger();
        
        // Test insert
        EmployeeLog log = new EmployeeLog(
            101,
            new Date(System.currentTimeMillis()),
            50000,
            "INITIAL_SALARY"
        );
        dao.insertLog(log);
        
        // Test retrieve
        List<EmployeeLog> logs = dao.getLogsByEmployee(101);
        for (EmployeeLog l : logs) {
            System.out.println("Log Date: " + l.getLogDate() + 
                             ", Action: " + l.getAction() +
                             ", New Salary: " + l.getNewSalary());
        }
    }
}