import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GetCookie extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        String name = "";
        String code = "";

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("personName")) {
                    name = c.getValue();
                }

                if (c.getName().equals("secretCode")) {
                    code = c.getValue();
                }
            }
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Cookie Details</h2>");
        out.println("<p>Person Name: " + name + "</p>");
        out.println("<p>Secret Code: " + code + "</p>");
        out.println("</body></html>");
    }
}
