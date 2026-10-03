<!DOCTYPE html>
<html>
<head>
    <title>Sports Event Registration</title>
</head>
<body>

<h2>Sports Event Registration</h2>

<form action="SportsRegistrationServlet" method="post">

    Student Name:
    <input type="text" name="studentName">
    <br><br>

    Roll Number:
    <input type="text" name="rollNumber">
    <br><br>

    Department:
    <input type="text" name="department">
    <br><br>

    Sports Event:

    <select name="sportsEvent">
        <option value="">Select Event</option>
        <option value="Cricket">Cricket</option>
        <option value="Football">Football</option>
        <option value="Basketball">Basketball</option>
        <option value="Athletics">Athletics</option>
    </select>

    <br><br>

    Contact Number:
    <input type="text" name="contactNumber">
    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>
