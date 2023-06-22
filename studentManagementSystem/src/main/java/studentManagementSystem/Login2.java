package studentManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;
import studentManagementSystem.dto.Student;

@SuppressWarnings("serial")
public class Login2 extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String gmail = req.getParameter("studentEmail");
		String pass= req.getParameter("studentPassword");
		
		StudentDao dao = new StudentDao();
	List<Student> studebtList 	=dao.getAllStudents();
	boolean value = false;
	
	for (Student student :studebtList)
	{
		
		if (student.getEmail().equals(gmail)) 
		{
			value = true;
			break;
		}
		
			
	}
		
		
	
	if(value == false)
	{
		// email is not present 
		 // PrintWriter writer = resp.getWriter();
		// writer.println("sorry email is not present ");
		RequestDispatcher dispatcher = req.getRequestDispatcher("Login2.html");
		dispatcher.include(req, resp);
		PrintWriter writer = resp.getWriter();
				 writer.println("sorry email is not present ");
		
	
	}
	else {
		
		// email is present 
		Student student = dao.getStudentByEmail(gmail);
		if(student.getPassword().equals(pass))
		{
			// login success
			// PrintWriter writer = resp.getWriter();
			// writer.println("login success");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("Display.html");
			dispatcher.forward(req, resp);
		}
		else {
			// log in failed
			
			// PrintWriter writer = resp.getWriter();
			// writer.println("password Wrong ");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login2.html");
			dispatcher.include(req, resp);
		}
	}
	
	
	}

}
