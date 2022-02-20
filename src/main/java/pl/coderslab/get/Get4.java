package pl.coderslab.get;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get4")
public class Get4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company = req.getParameter("company");
        String[] learn = req.getParameterValues("learn");

        resp.getWriter().println("company:");
        if (company != null) {
            resp.getWriter().println("- " + company);
        }

        resp.getWriter().println("learn:");
        if (learn != null && learn.length > 0) {
            for (String val : learn) {
                resp.getWriter().println("- " + val);
            }
        }
    }
}
