package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get3")
public class Get3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String widthParam = req.getParameter("width");
        String heightParam = req.getParameter("height");

        if (widthParam == null) {
            widthParam = "5";
        }
        if (heightParam == null) {
            heightParam = "10";
        }

        int width = Integer.parseInt(widthParam);
        int height = Integer.parseInt(heightParam);

        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                resp.getWriter().print(i * j + " ");
            }
            resp.getWriter().println();
        }
    }
}
