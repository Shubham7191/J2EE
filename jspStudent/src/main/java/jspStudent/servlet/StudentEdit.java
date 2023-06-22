package jspStudent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;


//@WebServlet("/edit")
public class StudentEdit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("Id"));
		
		
		String name = req.getParameter("Name");
		String email = req.getParameter("Email");
		String password = req.getParameter("Password");
		String address = req.getParameter("Address");
		long phone = Long.parseLong(req.getParameter("phone"));

		ServletContext context = getServletContext();
		String feesss = context.getInitParameter("Fees");
		double fees = Double.parseDouble(feesss);
		
		
		Student student = new Student();
		student.setStudentname(name);
		student.setStudentEmail(email);
		student.setStudentPassword(password);
		student.setStudentAddress(address);
	
		student.setPhone(phone);
		student.setFees(fees);
		
		
		
		// id should be same as previous that hit by user
		
		
		StudentDao dao = new StudentDao();
		Student student2= dao.updateStudent(id, student);
		
	List<Student> students=	dao.getAllStudent();
		
		req.setAttribute("list", students);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
		
	}

}
