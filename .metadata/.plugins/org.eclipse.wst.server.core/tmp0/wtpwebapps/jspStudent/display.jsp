

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="dto.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
	<h1>sucess full login</h1>

	<!-- this way we are printing first all student data  -->
	<% List<Student> students = (List)request.getAttribute("list"); %>
	<table border="2px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Address</th>
			<th>Phone Number</th>
			<th>Fees</th>
			<th>Delete</th>
			<th>Update</th>

		</tr>
		<%
		for (Student student : students) {
		%>
		<tr>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getStudentname()%></td>
			<td><%=student.getStudentEmail()%></td>
			<td><%=student.getStudentPassword()%></td>
			<td><%=student.getStudentAddress()%></td>
			<td><%=student.getPhone()%></td>
			<td><%=student.getFees()%></td>
			<td><a href="delete?id=<%=student.getStudentId()%>">Delete</a>
			</td>

			<!-- if i taken that id then clicking delete useing url (anchar tag ).i suppose to delete that id -->
			<!--  so we passing query string (delete?id=) equals to that particular id .-->



			<td><a href="Update?id=<%=student.getStudentId()%>">Update</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>