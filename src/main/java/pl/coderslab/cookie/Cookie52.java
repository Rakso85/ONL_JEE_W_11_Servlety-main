package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean found = false;
        Cookie cookie51 = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cookie51".equals(cookie.getName())) {
                    found = true;
                    cookie51 = cookie;
                    break;
                }
            }
        }

        if (found) {
            cookie51.setMaxAge(0);
            resp.addCookie(cookie51);
            resp.getWriter().println("Witamy na stronie Cookie52");
        } else {
            resp.sendRedirect("/cookie51?msg=" + URLEncoder.encode("Nie odwiedziłeś jeszcze tej strony", StandardCharsets.UTF_8));
        }
    }
}
