package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
    response.setContentType("text/html");
    response.getWriter().println(
        "<html><body>" +
        "<h2>Checkout</h2>" +
        "<form action='checkout' method='post'>" +
        "Name: <input type='text' name='name' required><br><br>" +
        "Phone: <input type='text' name='phone' required><br><br>" +
        "Address: <textarea name='address' required></textarea><br><br>" +
        "<input type='submit' value='Place Order'>" +
        "</form>" +
        "</body></html>"
    );
}
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    HttpSession session = request.getSession();
    HashMap<Integer, Integer> cart =
            (HashMap<Integer, Integer>) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
        response.getWriter().println("Cart is empty.");
        return;
    }
    try {
        Connection con = DBConnection.getConnection();
        StringBuilder cartDetails = new StringBuilder();
        for (Integer productId : cart.keySet()) {
            cartDetails.append("Product ID: ")
                       .append(productId)
                       .append(", Quantity: ")
                       .append(cart.get(productId))
                       .append("; ");
        }

        String sql =
            "INSERT INTO orders " +
            "(customer_name, phone, address, cart_details) " +
            "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setString(3, address);
        ps.setString(4, cartDetails.toString());
        ps.executeUpdate();
        ps.close();
        con.close();
        session.removeAttribute("cart");
        response.setContentType("text/html");
        response.getWriter().println(
            "<html><body>" +
            "<h2>Order Placed Successfully!</h2>" +
            "<p>Thank you, " + name + ".</p>" +
            "<a href='products'>Continue Shopping</a>" +
            "</body></html>"
        );
    } catch (Exception e) {
        e.printStackTrace();
        response.getWriter().println("Checkout failed.");
    }
}
}