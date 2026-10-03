package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("name") == null) {
        response.sendRedirect("login.html");
        return;
    }

    String name = (String) session.getAttribute("name");
    String email = (String) session.getAttribute("email");

    PrintWriter out = response.getWriter();

    out.println("<html><body>");
    out.println("<h2>User Profile</h2>");
    out.println("<p>Welcome, " + name + "!</p>");
    out.println("<p>Email: " + email + "</p>");
    out.println("<br>");
    out.println("<a href='logout'>Logout</a>");
    out.println("</body></html>");
}

}
