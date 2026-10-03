package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    HashMap<Integer, Integer> cart =
            (HashMap<Integer, Integer>) session.getAttribute("cart");
    String action = request.getParameter("action");
    String idValue = request.getParameter("id");
    if (cart != null && idValue != null) {
        int id = Integer.parseInt(idValue);
        if ("remove".equals(action)) {
            cart.remove(id);
        }
        if ("update".equals(action)) {
            int quantity =
                    Integer.parseInt(request.getParameter("quantity"));
            if (quantity > 0) {
                cart.put(id, quantity);
            }
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
        return;
    }
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h2>Shopping Cart</h2>");
    if (cart == null || cart.isEmpty()) {
        out.println("<p>Cart is empty.</p>");
        out.println("<a href='products'>View Products</a>");
    } else {
        double total = 0;
        try {
            Connection con = DBConnection.getConnection();
            for (Integer productId : cart.keySet()) {
                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM products WHERE id = ?");
                ps.setInt(1, productId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = cart.get(productId);
                    double itemTotal = price * quantity;
                    total += itemTotal;
                    out.println("<p>");
                    out.println("<b>" + name + "</b>");
                    out.println(" - Rs." + price);
                    out.println("<form action='cart' method='get'>");
                    out.println("<input type='hidden' name='action' value='update'>");
                    out.println("<input type='hidden' name='id' value='" + productId + "'>");
                    out.println(" Quantity: ");
                    out.println("<input type='number' name='quantity' value='" +
                            quantity + "' min='1'>");
                    out.println("<input type='submit' value='Update'>");
                    out.println("</form>");
                    out.println("<a href='cart?action=remove&id=" +
                            productId + "'>Remove</a>");
                    out.println("<br>");
                    out.println("Item Total: Rs." + itemTotal);
                    out.println("</p>");
                }
                rs.close();
                ps.close();
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error loading cart.");
        }
        out.println("<h3>Total: Rs." + total + "</h3>");
        out.println("<a href='checkout'>Checkout</a>");
        out.println("<br><br>");
        out.println("<a href='products'>Continue Shopping</a>");
    }
    out.println("</body></html>");
}
}