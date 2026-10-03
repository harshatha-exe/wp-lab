package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    String addId = request.getParameter("add");
    if (addId != null) {
        int productId = Integer.parseInt(addId);
        HashMap<Integer, Integer> cart =
                (HashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        cart.put(productId, cart.getOrDefault(productId, 0) + 1);
        session.setAttribute("cart", cart);
        response.sendRedirect("products");
        return;
    }
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h2>Product Catalog</h2>");
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM products");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            out.println("<p>");
            out.println("<b>" + name + "</b> - Rs." + price);
            out.println(" <a href='products?add=" + id + "'>Add to Cart</a>");
            out.println("</p>");
        }
        out.println("<br>");
        out.println("<a href='cart'>View Cart</a>");
        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error loading products.");
    }
    out.println("</body></html>");
}
}