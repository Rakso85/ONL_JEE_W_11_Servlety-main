package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@WebServlet("/session5")
public class Session5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");

        HttpSession session = req.getSession();
        Random r = new Random();
        int num1 = r.nextInt(100);
        int num2 = r.nextInt(100);
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);

        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Session 5</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/session5\" method=\"post\">\n" +
                "    <label>\n" +
                "        Imię: <input type=\"text\" name=\"firstName\"/>\n" +
                "    </label><br/>\n" +
                "    <label>\n" +
                "        Nazwisko: <input type=\"text\" name=\"lastName\"/>\n" +
                "    </label><br/>\n" +
                "    <label>\n" +
                "        Email: <input type=\"email\" name=\"email\"/>\n" +
                "    </label><br/>\n" +
                "    <p>\n" +
                "        Podaj wynik dodawania " + num1 + " + " + num2 + " = <input type=\"number\" name=\"result\"/>\n" +
                "    </p>\n" +
                "    <button type=\"submit\">Wyślij</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        int result = Integer.parseInt(req.getParameter("result"));
        HttpSession session = req.getSession();
        int num1 = (int) session.getAttribute("num1");
        int num2 = (int) session.getAttribute("num2");

        if (result != num1 + num2) {
            resp.sendRedirect("/session5");
            return;
        }

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        resp.getWriter().println("Twoje dane:");
        resp.getWriter().println("- imię: " + firstName);
        resp.getWriter().println("- nazwisko: " + lastName);
        resp.getWriter().println("- email: " + email);
    }
}
