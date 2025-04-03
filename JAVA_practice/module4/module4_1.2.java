import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Module4Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String data = context.getInitParameter("dataParameter");
        System.out.println("Fetched data from web.xml: " + data);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello from Module4Servlet!");
    }
}
