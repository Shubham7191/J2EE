<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>

<%  String message =(String)request.getAttribute("message"); %>
<!-- this message should same as sign up Servlet req.setAttribute -->
<% if(message != null ){  %>
<%= message %>

<%} %>



<form action="SignUp" method="post">
<label>Id:</label>
<input type="number" name="Id">
<br>
<br>
<label>Name</label>
<input type="text" name="Name">
<br>
<br>

<label>Address</label>
<input type="text" name="Address">
<br>
<br>
<label>Phone</label>
<input type="number" name="phone">
<br>
<br>
<label>Email</label>
<input type="email" name="Email">
<br>
<br>

<label>Password</label>
<input type="password" name="Password">
<br>
<label></label>
<input type="submit" value="SUBMIT">
</form>
</body>
</html>