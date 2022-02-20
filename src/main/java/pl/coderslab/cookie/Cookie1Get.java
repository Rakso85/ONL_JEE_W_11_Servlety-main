package pl.coderslab.cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {

    private static final String USER_COOKIE_NAME = "User";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Jeżeli nie ma żadnych ciasteczek przesłanych w żądaniu, to metoda getCookies()
        // zwraca null!
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (USER_COOKIE_NAME.equals(cookie.getName())) {
                    resp.getWriter().println(USER_COOKIE_NAME + ": " + cookie.getValue());
                    return;
                }
            }
        }
        resp.getWriter().println("Brak ciasteczka " + USER_COOKIE_NAME);
    }
}
