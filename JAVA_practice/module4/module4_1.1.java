import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class module4_1_1 extends HttpServlet {
    private String someParameter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        someParameter = config.getInitParameter("someParameter");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("Parameter from web.xml: " + someParameter);
    }
}
