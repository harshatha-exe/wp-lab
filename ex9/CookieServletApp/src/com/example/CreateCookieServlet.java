package com.example;
import jakarta.servlet.*
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String name = request.getParameter("name");
    String secretCode = request.getParameter("secretCode");
    Cookie nameCookie = new Cookie("name", name);
    Cookie secretCookie = new Cookie("secretCode", secretCode);
    response.addCookie(nameCookie);
    response.addCookie(secretCookie);
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h2>Cookies Created Successfully!</h2>");
    out.println("<a href='readCookie'>View Cookie Details</a>");
    out.println("</body></html>");
}
}