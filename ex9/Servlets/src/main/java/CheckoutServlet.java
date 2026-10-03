import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;

public class CheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        HttpSession session = request.getSession();

        ArrayList<String[]> cart =
            (ArrayList<String[]>) session.getAttribute("cart");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopdb",
                "root",
                "root"
            );

            String sql =
                "INSERT INTO orders(name,email,address,product,quantity,total)"
                + " VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            if (cart != null) {

                for (String[] item : cart) {

                    String product = item[0];

                    double price =
                        Double.parseDouble(item[1]);

                    int quantity =
                        Integer.parseInt(item[2]);

                    double total = price * quantity;

                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, address);
                    ps.setString(4, product);
                    ps.setInt(5, quantity);
                    ps.setDouble(6, total);

                    ps.executeUpdate();
                }
            }

            cart.clear();

            con.close();

            out.println("<html><body>");

            out.println("<h2>Order Placed Successfully!</h2>");

            out.println("<p>Thank you, " + name + ".</p>");

            out.println("<p>Your order has been stored in the database.</p>");

            out.println("<a href='products.html'>Continue Shopping</a>");

            out.println("</body></html>");

        } catch (Exception e) {

            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
