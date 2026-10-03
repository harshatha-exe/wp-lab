import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class AddToCart extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String product = request.getParameter("product");
        double price = Double.parseDouble(
            request.getParameter("price")
        );

        HttpSession session = request.getSession();

        ArrayList<String[]> cart =
            (ArrayList<String[]>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<String[]>();
        }

        boolean found = false;

        for (String[] item : cart) {

            if (item[0].equals(product)) {

                int quantity = Integer.parseInt(item[2]);

                item[2] = String.valueOf(quantity + 1);

                found = true;
                break;
            }
        }

        if (!found) {

            String[] item = {
                product,
                String.valueOf(price),
                "1"
            };

            cart.add(item);
        }

        session.setAttribute("cart", cart);

        response.sendRedirect("products.html");
    }
}
