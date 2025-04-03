import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;

public class module4_1_4 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String data = context.getInitParameter("dataParameter");
        context.setAttribute("fetchedData", data);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/displayData.jsp").forward(request, response);
    }
}
