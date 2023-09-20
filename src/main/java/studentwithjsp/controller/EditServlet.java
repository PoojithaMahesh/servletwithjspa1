package studentwithjsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		double fees=Double.parseDouble(getServletContext().getInitParameter("fees"));
		
		Student student=new Student();
		student.setId(id);
		student.setAddress(address);
		student.setEmail(email);
		student.setFees(fees);
		student.setName(name);
		student.setPassword(password);
        student.setPhone(phone);		
		
		StudentDao studentDao=new StudentDao();
		studentDao.updateStudent(student);
		
		
		Cookie[] cookies=req.getCookies();
		String nameofthestudentwhologgedinandchangedthedata=null;
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("nameofthestudentwhologgein")) {
				nameofthestudentwhologgedinandchangedthedata=cookie.getValue();
				break;
			}
			
		}
		
		
		
		
		
		req.setAttribute("namewhochangedthedata", nameofthestudentwhologgedinandchangedthedata);
		req.setAttribute("listofstudents", studentDao.getAllStudents());
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	
	}

}
