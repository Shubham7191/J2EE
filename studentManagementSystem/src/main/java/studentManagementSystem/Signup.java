package studentManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;
import studentManagementSystem.dto.Student;

@SuppressWarnings("serial")
public class Signup extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String name = req.getParameter("studentName");
		String email = req.getParameter("studentEmail");
		String password = req.getParameter("studentPassword");
		
		PrintWriter writer = resp.getWriter();
		writer.print(name);
		writer.print(email);
		writer.print(password);
		
		
		
		
		Student student = new Student();
		
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		
		StudentDao dao = new StudentDao();
		Student dbstudent = dao.saveStudentDao(student);
		
		
		if (dbstudent != null ) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login2.html");
				dispatcher.forward(req, resp);
		}
		
		
		
		// to get proper response and secure version we use  post method 
		//httpservlet
		//genericservlet  is not build for dopost method it will work but its not good way to use genericservlet 
		//The RequestDispatcher is an interface in Java Servlet API that provides a way to forward the request from one JSP page to another Jsp page.
		// getRequestDispatcher is an method of httpssevletRequest interface its return dispatcher opject and also it 
		//When you obtain a RequestDispatcher object using the getRequestDispatcher method, it represents a target resource to which you want to forward or include the request. 
	
	
	}

	

}
