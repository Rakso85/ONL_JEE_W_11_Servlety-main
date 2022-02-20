package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookie51")
public class Cookie51 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Cookie cookie = new Cookie("cookie51", "");
        resp.addCookie(cookie);

        String msg = req.getParameter("msg");
        if (msg != null) {
            resp.getWriter().println("Wiadomość dla Ciebie: " + msg);
        }
        resp.getWriter().println("<a href='/cookie52'>Idź dalej</a>");
    }
}
