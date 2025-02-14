import java.sql.*;
import java.text.SimpleDateFormat;

public class EmployeeDataInsertion {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public void insertEmployeeData() {
        String insertSQL = "INSERT INTO EMP (Empno, Ename, Job, Mgr, Hiredate, Sal, Comm, Deptno) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            
            // Clear existing data
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM EMP");
            
            // Employee data array
            Object[][] employeeData = {
                {7369, "SMITH", "CLERK", 7902, "1980-12-17", 800.00, null, 20},
                {7499, "ALLEN", "SALESMAN", 7698, "1981-02-20", 1600.00, 300.00, 30},
                {7521, "WARD", "SALESMAN", 7698, "1981-02-22", 1250.00, 500.00, 30},
                {7566, "JONES", "MANAGER", 7839, "1981-04-02", 2975.00, null, 20},
                {7654, "MARTIN", "SALESMAN", 7698, "1981-09-28", 1250.00, 1400.00, 30},
                {7698, "BLAKE", "MANAGER", 7839, "1981-05-01", 2850.00, null, 30},
                {7782, "CLARK", "MANAGER", 7839, "1981-06-09", 2450.00, null, 10},
                {7788, "SCOTT", "ANALYST", 7566, "1987-06-11", 3000.00, null, 20},
                {7839, "KING", "PRESIDENT", null, "1981-11-17", 5000.00, null, 10},
                {7844, "TURNER", "SALESMAN", 7698, "1981-08-09", 1500.00, 0.00, 30},
                {7876, "ADAMS", "CLERK", 7788, "1987-07-13", 1100.00, null, 20},
                {7900, "JAMES", "CLERK", 7698, "1981-03-12", 950.00, null, 30},
                {7902, "FORD", "ANALYST", 7566, "1981-03-12", 3000.00, null, 20},
                {7934, "MILLER", "CLERK", 7782, "1982-01-23", 1300.00, null, 10}
            };

            // Insert each employee
            for (Object[] employee : employeeData) {
                pstmt.setInt(1, (Integer) employee[0]);        // Empno
                pstmt.setString(2, (String) employee[1]);      // Ename
                pstmt.setString(3, (String) employee[2]);      // Job
                
                // Handle null MGR
                if (employee[3] == null) {
                    pstmt.setNull(4, Types.INTEGER);
                } else {
                    pstmt.setInt(4, (Integer) employee[3]);
                }
                
                // Convert string date to SQL Date
                pstmt.setDate(5, Date.valueOf((String) employee[4]));  // Hiredate
                
                // Handle salary as double
                pstmt.setDouble(6, (Double) employee[5]);      // Sal
                
                // Handle null COMM
                if (employee[6] == null) {
                    pstmt.setNull(7, Types.DECIMAL);
                } else {
                    pstmt.setDouble(7, (Double) employee[6]);
                }
                
                pstmt.setInt(8, (Integer) employee[7]);        // Deptno
                
                pstmt.executeUpdate();
            }
            
            System.out.println("Employee data inserted successfully!");
            
        } catch (SQLException e) {
            System.out.println("Error inserting employee data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Verify data insertion
    public void verifyData() {
        String sql = "SELECT * FROM EMP ORDER BY Empno";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\nVerifying inserted data:");
            System.out.println("EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL    | COMM   | DEPTNO");
            System.out.println("------|--------|-----------|------|------------|--------|--------|-------");
            
            while (rs.next()) {
                System.out.printf("%-6d | %-7s | %-10s | %-5s | %-11s | %-7.2f | %-7s | %-7d%n",
                    rs.getInt("Empno"),
                    rs.getString("Ename"),
                    rs.getString("Job"),
                    rs.getObject("Mgr") == null ? "NULL" : rs.getInt("Mgr"),
                    rs.getDate("Hiredate"),
                    rs.getDouble("Sal"),
                    rs.getObject("Comm") == null ? "NULL" : rs.getDouble("Comm"),
                    rs.getInt("Deptno")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("Error verifying data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeDataInsertion dataInsertion = new EmployeeDataInsertion();
        dataInsertion.insertEmployeeData();
        dataInsertion.verifyData();
    }
}