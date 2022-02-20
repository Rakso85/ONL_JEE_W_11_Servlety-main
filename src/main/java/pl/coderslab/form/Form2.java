package pl.coderslab.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    private static final Set<String> CENSORED_WORDS = Set.of("dupa", "cholera", "bazyliszek");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String message = req.getParameter("message");
        String aware = req.getParameter("aware");

        String censoredMessage = message;
        if (!"true".equals(aware)) {
            for (String word : CENSORED_WORDS) {
                censoredMessage = censoredMessage.replaceAll("(?i)" + word, "*".repeat((word.length())));
            }
        }
        resp.getWriter().println(censoredMessage);

    }
}
