package studentwithjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		ServletContext context=getServletContext();
		double fees=Double.parseDouble(context.getInitParameter("fees"));
		
		Student student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setFees(fees);
		student.setName(name);
		student.setPassword(password);
		student.setPhone(phone);
		
		StudentDao studentDao=new StudentDao();
		List<Student> list=studentDao.getAllStudents();
		boolean value=false;
		for(Student student1:list) {
			if(student1.getEmail().equals(email)) {
				value=true;
				break;
			}
		}
		if(value) {
//			email already present
			req.setAttribute("message", "EMAIL ALREADY EXIST");
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
			
		}else {
//			email is not present in the database
//			i should allow him to signup
			studentDao.signupStudent(student);
			req.setAttribute("message", "SIGNEDUPSUCCESSFULLY");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		
		
		
        
	}
}
