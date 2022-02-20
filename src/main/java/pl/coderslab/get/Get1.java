package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get1")
public class Get1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startParam = req.getParameter("start");
        String endParam = req.getParameter("end");

        if (startParam == null || endParam == null) {
            resp.getWriter().println("BRAK");
            return; // lub dalsza część kodu jako blok else
        }

        int start = Integer.parseInt(startParam);
        int end = Integer.parseInt(endParam);

        for (int i = start; i <= end; i++) {
            resp.getWriter().println(i);
        }
    }
}
