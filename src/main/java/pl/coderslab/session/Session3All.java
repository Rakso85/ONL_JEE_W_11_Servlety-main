package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        List<String> attributes;
        HttpSession session = req.getSession();
        if (session.getAttribute("items") != null) {
            attributes = (List<String>) session.getAttribute("items");
        } else {
            attributes = new ArrayList<>();
            session.setAttribute("items", attributes);
        }

        for (String attributeName : attributes) {
            String attributeValue = (String) session.getAttribute(attributeName);
            resp.getWriter().println("<p><b>" + attributeName + "</b> = " + attributeValue);
        }
    }
}
