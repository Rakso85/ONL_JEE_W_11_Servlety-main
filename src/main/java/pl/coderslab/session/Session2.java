package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Double> degrees;
        HttpSession session = req.getSession();
        if (session.getAttribute("degrees") != null) {
            degrees = (List<Double>) session.getAttribute("degrees");
        } else {
            degrees = new ArrayList<>();
            session.setAttribute("degrees", degrees);
        }
        double averageDegree = degrees.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Session 2</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Lista ocen:</h1>\n" +
                "<ul>\n");

        for(Double degree : degrees) {
            resp.getWriter().println("    <li>" + degree + "</li>\n");
        }

        resp.getWriter().println("</ul>\n" +
                "<h1>Średnia: " + averageDegree + "</h1>\n" +
                "<form action=\"/session2\" method=\"post\">\n" +
                " Ocena: <input type=\"number\" min=\"1\" max=\"6\" step=\"0.5\" name=\"degree\"/><button type=\"submit\">Dodaj</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Double> degrees;
        HttpSession session = req.getSession();
        if (session.getAttribute("degrees") != null) {
            degrees = (List<Double>) session.getAttribute("degrees");
        } else {
            degrees = new ArrayList<>();
            session.setAttribute("degrees", degrees);
        }

        double degree = Double.parseDouble(req.getParameter("degree"));
        degrees.add(degree);

        resp.sendRedirect("/session2");
    }
}
