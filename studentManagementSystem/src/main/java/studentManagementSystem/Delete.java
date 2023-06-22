package studentManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;
import studentManagementSystem.dto.Student;

@SuppressWarnings("serial")
public class Delete  extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		Student student = dao.deleteStudent(id);
		
		
		if(student != null)
		{
			PrintWriter writer = resp.getWriter();
			writer.print("student is deleted");
		}
		else {
			
			PrintWriter writer = resp.getWriter();
			writer.print("please enter correct id given id is null "); 
		}
		
	}

}
