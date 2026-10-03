<%@ page import="beans.InterestBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Interest Result</title>
</head>
<body>

<h2>Simple Interest Result</h2>

<%
    String ps = request.getParameter("p");
    String ns = request.getParameter("n");
    String rs = request.getParameter("r");

    if (ps != null && ns != null && rs != null) {

        double p = Double.parseDouble(ps);
        double n = Double.parseDouble(ns);
        double r = Double.parseDouble(rs);

        InterestBean obj = new InterestBean();

        obj.setP(p);
        obj.setN(n);
        obj.setR(r);
%>

<p>Principal Amount: <%= obj.getP() %></p>

<p>Number of Years: <%= obj.getN() %></p>

<p>Rate of Interest: <%= obj.getR() %>%</p>

<p>
    <b>Simple Interest:
        <%= obj.getInterest() %>
    </b>
</p>

<%
    }
%>

</body>
</html>
