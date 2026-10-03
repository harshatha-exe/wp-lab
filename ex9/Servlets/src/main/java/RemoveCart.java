import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class RemoveCart extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String product = request.getParameter("product");

        HttpSession session = request.getSession();

        ArrayList<String[]> cart =
            (ArrayList<String[]>) session.getAttribute("cart");

        if (cart != null) {

            for (int i = 0; i < cart.size(); i++) {

                if (cart.get(i)[0].equals(product)) {

                    cart.remove(i);

                    break;
                }
            }
        }

        response.sendRedirect("CartServlet");
    }
}
