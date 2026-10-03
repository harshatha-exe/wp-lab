import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<String[]> cart =
            (ArrayList<String[]>) session.getAttribute("cart");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<h2>Shopping Cart</h2>");

        if (cart == null || cart.size() == 0) {

            out.println("<p>Your cart is empty.</p>");

        } else {

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>Product</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Total</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            double grandTotal = 0;

            for (String[] item : cart) {

                String product = item[0];

                double price =
                    Double.parseDouble(item[1]);

                int quantity =
                    Integer.parseInt(item[2]);

                double total = price * quantity;

                grandTotal += total;

                out.println("<tr>");

                out.println("<td>" + product + "</td>");

                out.println("<td>" + price + "</td>");

                out.println("<td>");

                out.println("<form action='UpdateCart' method='post'>");

                out.println("<input type='hidden' name='product' value='"
                            + product + "'>");

                out.println("<input type='number' name='quantity' value='"
                            + quantity + "' min='1'>");

                out.println("<input type='submit' value='Update'>");

                out.println("</form>");

                out.println("</td>");

                out.println("<td>" + total + "</td>");

                out.println("<td>");

                out.println("<a href='RemoveCart?product="
                            + product + "'>Remove</a>");

                out.println("</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<h3>Grand Total: ₹" + grandTotal + "</h3>");

            out.println("<a href='products.html'>Continue Shopping</a>");
            out.println("<br><br>");
            out.println("<a href='checkout.html'>Checkout</a>");
        }

        out.println("</body></html>");
    }
}
