package jspStudent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

public class StudentSignup extends HttpServlet {

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
		StudentDao dao = new StudentDao();
		
		
		List<Student> studentsAllList = dao.getAllStudent();

		boolean value = false;

		for (Student singleStudent : studentsAllList) {
			if (singleStudent.getStudentEmail().equals(email))
			{
				value = true;
				break;
			}
		}

		// email is already present means value = true
		// email is not presrnt means = false;

		if (value == false) {
			// email is not already present so i can wright logic here and insert student object into database
			// database
			student.setFees(fees);

			student.setStudentId(id);
			student.setStudentname(name);
			student.setPhone(phone);
			student.setStudentAddress(address);
			student.setStudentEmail(email);
			student.setStudentPassword(password);

			Student dbstudent = dao.saveStudent(student);

			
				req.setAttribute("message", "log in successfully (through sign up directly we log in )");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}

		

		else {
			req.setAttribute("message", "SORRY EMAIL IS ALREADY EXIST");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Signup.jsp");
			dispatcher.include(req, resp);
		}

	}

}
