 package jspStudent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/Login") 
// this web servlet is work same as url pattern 
// this name should be unique so because here conatiner check all servlet classes so 
public class StudentLogin extends HttpServlet{
	@Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		PrintWriter writer = resp.getWriter();
//		writer.println("Login url hit ");
		
		
		//this name should same as that jsp page namae (ex: "EMail" ,"password")
		String email = req.getParameter("Email");
		String password = req.getParameter("Password");
		
		
		
		
		StudentDao dao = new StudentDao();
		//dao.getAllStudent(); useing this we are retriving
		List <Student> studentAll= dao.getAllStudent();
		
		
		
		boolean value= false;
		for(Student student1 : studentAll)
		{
			if(student1.getStudentEmail().equals(email) );
			value = true;
			break;
		}
		
		if(value == false)
		{
			//email is not present 
			req.setAttribute("message", "email is not correct please wright correct");
			 

			RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		else {
			
			//email is present
			
			Student student = dao.getStudentByEmail(email);
			if (student.getStudentPassword().equals(password))
			{
				req.setAttribute("list", studentAll);
				//we are passing list beacuse to show all list in display.jsp page whenever we renter the page 
				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("message", "InCORRECT PASSWORD");
				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
				dispatcher.include(req, resp);
			}
		}
		
		
	}

}
