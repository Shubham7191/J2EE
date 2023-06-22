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

public class Display extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		StudentDao dao = new  StudentDao();
		Student student=dao.selectStudent(id);
		if (student != null) {
			
			PrintWriter writer = resp.getWriter();
			
			writer.print(student.getId());

			writer.print(student.getEmail());

			writer.print(student.getPassword());

			writer.print(student.getName());

			
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Display.html");
			dispatcher.include(req, resp);
		}
		
	}

}
