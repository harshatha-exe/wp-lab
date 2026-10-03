package com.sports;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.sql.*;

@Named("sportsBean")
@RequestScoped
public class SportsRegistrationBean {
    private String studentName;
    private Long rollNumber; // Long handles numeric validation automatically
    private String department;
    private String sportsEvent;
    private Long contactNumber;

    // Getters and Setters
    public String getStudentName() { return studentName; }
    public void setStudentName(String s) { this.studentName = s; }
    public Long getRollNumber() { return rollNumber; }
    public void setRollNumber(Long r) { this.rollNumber = r; }
    public String getDepartment() { return department; }
    public void setDepartment(String d) { this.department = d; }
    public String getSportsEvent() { return sportsEvent; }
    public void setSportsEvent(String e) { this.sportsEvent = e; }
    public Long getContactNumber() { return contactNumber; }
    public void setContactNumber(Long c) { this.contactNumber = c; }

    public String register() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsdb", "root", "root");
            
            String query = "INSERT INTO sports_registration (student_name, roll_number, department, sports_event, contact_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentName);
            ps.setLong(2, rollNumber);
            ps.setString(3, department);
            ps.setString(4, sportsEvent);
            ps.setLong(5, contactNumber);
            
            int status = ps.executeUpdate();
            con.close();
            
            return (status > 0) ? "success" : "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}