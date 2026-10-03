package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html");

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);

        ps.executeUpdate();

        ps.close();
        con.close();

        response.sendRedirect("login.html");

    } catch (Exception e) {

        e.printStackTrace();

        response.getWriter().println("<h2>Registration Failed</h2>");
        response.getWriter().println("<p>" + e.getMessage() + "</p>");
    }
}

}
