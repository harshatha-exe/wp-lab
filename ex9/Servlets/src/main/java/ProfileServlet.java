import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("name") == null) {

            response.sendRedirect("login.html");
            return;
        }

        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<h2>Welcome to Your Profile</h2>");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("<a href='LogoutServlet'>Logout</a>");

        out.println("</body></html>");
    }
}
