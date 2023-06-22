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
public class Update  extends HttpServlet{

	
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("studentName");
		
		StudentDao dao = new StudentDao();
		Student studentDB = dao.updateStudent(id,  name );
		PrintWriter writer = resp.getWriter();
		
		if (studentDB != null )
		{
			
			writer.println("updated ");
			
		}
		else {
			
			writer.println("id is null  please check id to update");
			
		}
		
		
	}
	
	
}
