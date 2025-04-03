import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentCRUD")
public class module4_1_16 extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database"; // Update with your database URL
    private static final String USERNAME = "your_username"; // Update with your database username
    private static final String PASSWORD = "your_password"; // Update with your database password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            deleteStudent(request);
        }
        response.sendRedirect("studentList.jsp"); // Redirect to a page that lists students
    }

    private void deleteStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        
        // Store deleted record in deleted_data table
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO deleted_data (id, fname, lname) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.setString(2, fname);
                statement.setString(3, lname);
                statement.executeUpdate();
            }

            // Now delete the student from the original table
            sql = "DELETE FROM students WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
