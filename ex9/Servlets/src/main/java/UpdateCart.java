import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class UpdateCart extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String product = request.getParameter("product");

        int quantity =
            Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();

        ArrayList<String[]> cart =
            (ArrayList<String[]>) session.getAttribute("cart");

        if (cart != null) {

            for (String[] item : cart) {

                if (item[0].equals(product)) {

                    item[2] = String.valueOf(quantity);

                    break;
                }
            }
        }

        response.sendRedirect("CartServlet");
    }
}
