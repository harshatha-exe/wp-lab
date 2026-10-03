package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();
    String name = "";
    String secretCode = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                name = cookie.getValue();
            }
            if (cookie.getName().equals("secretCode")) {
                secretCode = cookie.getValue();
            }
        }
    }
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h2>Cookie Details</h2>");
    out.println("<p>Name: " + name + "</p>");
    out.println("<p>Secret Code: " + secretCode + "</p>");
    out.println("</body></html>");
}
}