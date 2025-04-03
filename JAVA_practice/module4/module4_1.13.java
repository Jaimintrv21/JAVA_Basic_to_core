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
public class module4_1_13 extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database"; // Update with your database URL
    private static final String USERNAME = "your_username"; // Update with your database username
    private static final String PASSWORD = "your_password"; // Update with your database password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        // Validate email using regular expression
        if (!validateEmail(email)) {
            response.getWriter().println("Invalid email format.");
            return;
        }

        // Perform CRUD operation (Create)
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO students (fname, lname, email, mobile, gender, password) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, fname);
                statement.setString(2, lname);
                statement.setString(3, email);
                statement.setString(4, mobile);
                statement.setString(5, gender);
                statement.setString(6, password);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("success.jsp"); // Redirect to a success page
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}
