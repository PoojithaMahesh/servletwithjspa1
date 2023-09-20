package studentwithjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/update")
public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao studentDao=new StudentDao();
		Student dbStudent=studentDao.findstudentById(id);
		req.setAttribute("student", dbStudent);
		HttpSession httpSession=req.getSession();
		String name=(String)httpSession.getAttribute("namewhologgedin");
		if(name!=null) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "HeyIdiotFellowFirstLogginandthencmebacktothiseditpage");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	
	}
}
