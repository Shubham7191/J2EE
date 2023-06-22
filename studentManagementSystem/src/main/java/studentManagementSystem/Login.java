package studentManagementSystem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;

@SuppressWarnings("serial")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String email =req.getParameter("studentEmail");
		String password = req.getParameter("studentPassword");
		
		StudentDao dao = new StudentDao();
		dao.loginStudent(email, password);
		
		
	}

}
