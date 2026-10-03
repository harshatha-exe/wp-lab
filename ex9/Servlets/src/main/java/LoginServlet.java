import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/servletdb",
                "root",
                "root"
            );

            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session = request.getSession();

                session.setAttribute("name", rs.getString("name"));
                session.setAttribute("email", rs.getString("email"));

                response.sendRedirect("ProfileServlet");

            } else {

                response.setContentType("text/html");

                PrintWriter out = response.getWriter();

                out.println("<h3>Invalid Email or Password</h3>");
                out.println("<a href='login.html'>Try Again</a>");
            }

            con.close();

        } catch (Exception e) {

            PrintWriter out = response.getWriter();

            out.println(e.getMessage());
        }
    }
}
