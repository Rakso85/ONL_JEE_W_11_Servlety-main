package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
public class Session4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        List<CartItem> items;
        HttpSession session = req.getSession();
        if (session.getAttribute("items") != null) {
            items = (List<CartItem>) session.getAttribute("items");
        } else {
            items = new ArrayList<>();
            session.setAttribute("items", items);
        }

        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Session4</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Dodaj produkt</h1>\n" +
                "<form action=\"/session4\" method=\"post\">\n" +
                "    <label>\n" +
                "        Nazwa: <input type=\"text\" name=\"name\"/>\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Ilość: <input type=\"number\" min=\"1\" max=\"100\" name=\"quantity\"/>\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Cena: <input type=\"number\" min=\"0.01\" max=\"9999.99\" step=\"0.01\" name=\"price\"/>\n" +
                "    </label>\n" +
                "    <button type=\"submit\">Dodaj</button>\n" +
                "</form>");

        resp.getWriter().println("<h1>Lista produktów</h1>");
        for (CartItem item : items) {
            resp.getWriter().printf("%s - %d x %.2f = %.2f", item.getName(), item.getQuantity(), item.getPrice(), item.getQuantity() * item.getPrice());
        }

        resp.getWriter().println("\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        List<CartItem> items;
        HttpSession session = req.getSession();
        if (session.getAttribute("items") != null) {
            items = (List<CartItem>) session.getAttribute("items");
        } else {
            items = new ArrayList<>();
            session.setAttribute("items", items);
        }

        String itemName = req.getParameter("name");
        Integer itemQuantity = Integer.valueOf(req.getParameter("quantity"));
        Double itemPrice = Double.valueOf(req.getParameter("price"));

        items.add(new CartItem(itemName, itemQuantity, itemPrice));
        resp.sendRedirect("/session4");
    }
}