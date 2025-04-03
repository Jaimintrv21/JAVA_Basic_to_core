import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database"; // Update with your database URL
    private static final String USERNAME = "your_username"; // Update with your database username
    private static final String PASSWORD = "your_password"; // Update with your database password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        
        // Validate email uniqueness
        if (!isEmailUnique(email)) {
            response.getWriter().println("Email already exists.");
            return;
        }

        // Insert user into database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO users (fname, lname, email, mobile) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, fname);
                statement.setString(2, lname);
                statement.setString(3, email);
                statement.setString(4, mobile);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Send confirmation email with OTP (pseudo-code)
        String otp = sendConfirmationEmail(email);
        request.getSession().setAttribute("otp", otp);
        response.getWriter().println("Registration successful. Check your email for OTP.");
    }

    private boolean isEmailUnique(String email) {
        // Check if email exists in the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1) == 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String sendConfirmationEmail(String email) {
        // Logic to send email and generate OTP
        String otp = String.valueOf((int)(Math.random() * 10000)); // Generate a random OTP
        // Send email logic here (pseudo-code)
        return otp;
    }
}

@WebServlet("/verifyOtp")
public class VerifyOtpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enteredOtp = request.getParameter("otp");
        String sessionOtp = (String) request.getSession().getAttribute("otp");

        if (enteredOtp.equals(sessionOtp)) {
            response.getWriter().println("OTP verified. You can now log in.");
        } else {
            response.getWriter().println("Invalid OTP. Please try again.");
        }
    }
}

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // Assume password is handled

        // Validate user credentials (pseudo-code)
        if (validateUser(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            response.getWriter().println("Login successful.");
        } else {
            response.getWriter().println("Invalid credentials.");
        }
    }

    private boolean validateUser(String email, String password) {
        // Logic to validate user credentials
        return true; // Placeholder
    }
}

@WebServlet("/sendMessage")
public class SendMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromEmail = (String) request.getSession().getAttribute("userEmail");
        String toEmail = request.getParameter("toEmail");
        String message = request.getParameter("message");

        // Insert message into database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO messages (fromEmail, toEmail, message) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, fromEmail);
                statement.setString(2, toEmail);
                statement.setString(3, message);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().println("Message sent.");
    }
}

@WebServlet("/viewMessages")
public class ViewMessagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("userEmail");

        // Fetch messages from database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM messages WHERE toEmail = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    // Process messages (pseudo-code)
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.getWriter().println("Logged out successfully.");
    }
}
