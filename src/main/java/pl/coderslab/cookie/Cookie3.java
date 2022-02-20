package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("key");
        String cookieValue = req.getParameter("value");
        int time = Integer.parseInt(req.getParameter("time"));
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setMaxAge(time * 60 * 60);
        resp.addCookie(cookie);

    }
}
