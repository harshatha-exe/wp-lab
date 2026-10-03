import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class CreateCookie extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String name = request.getParameter("name");
        String code = request.getParameter("code");

        Cookie nameCookie = new Cookie("personName", name);
        Cookie codeCookie = new Cookie("secretCode", code);

        response.addCookie(nameCookie);  
        response.addCookie(codeCookie);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Cookies Created Successfully!</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Secret Code: " + code + "</p>");
        out.println("<a href='GetCookie'>View Cookie Details</a>");
        out.println("</body></html>");
    }
}
