<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>


<%String message = (String)request.getAttribute("message"); %>


	<%-- <%= message %>  --%>
<!-- we need to check and check null -->

<% if(message != null) 

  { %>
	<%= message %>
	 
	 <!-- we can not wright jsp tag inside jsp tag so wright this way -->
	
	<br>
	
<%} %>

<br>

<form action="Login" method="post">
<label>Email</label>
<input type="email" name = "Email">
<label>Password</label>
<input type="password" name = "Password">
<input type="submit" value="Login ">

</form>
</body>
</html>