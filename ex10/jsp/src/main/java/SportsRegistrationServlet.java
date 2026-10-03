import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SportsRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String name = request.getParameter("studentName");
        String roll = request.getParameter("rollNumber");
        String dept = request.getParameter("department");
        String event = request.getParameter("sportsEvent");
        String contact = request.getParameter("contactNumber");

        // Check empty fields
        if (name == null || name.trim().isEmpty() ||
            roll == null || roll.trim().isEmpty() ||
            dept == null || dept.trim().isEmpty() ||
            event == null || event.trim().isEmpty() ||
            contact == null || contact.trim().isEmpty()) {

            response.sendRedirect("error.jsp");
            return;
        }

        // Check numeric values
        try {

            int rollNumber = Integer.parseInt(roll);
            long contactNumber = Long.parseLong(contact);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sportsdb",
                "root",
                "root"
            );

            String sql = "INSERT INTO sports_registration " +
                         "(student_name, roll_number, department, " +
                         "sports_event, contact_number) " +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, rollNumber);
            ps.setString(3, dept);
            ps.setString(4, event);
            ps.setLong(5, contactNumber);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

            con.close();

        } catch (NumberFormatException e) {

            response.sendRedirect("error.jsp");

        } catch (Exception e) {

            response.sendRedirect("error.jsp");
        }
    }
}
