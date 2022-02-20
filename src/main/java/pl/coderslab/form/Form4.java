package pl.coderslab.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/post4")
public class Form4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("c"));
        double c = Double.parseDouble(req.getParameter("b"));

        double delta = b*b - 4 * a * c;
        if (delta < 0) {
            resp.getWriter().println("Brak miejsc zerowych");
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            resp.getWriter().println("Jedno miejsce zerowe " + x0);
        }
        else {
            double x1 = (-b - Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta) / (2*a));
            resp.getWriter().println("Pierwsze miejsce zerowe " + x1);
            resp.getWriter().println("Drugie miejsce zerowe " + x2);
        }
    }
}
