package studentwithjsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.RDMSOS2200Dialect;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	StudentDao studentDao=new StudentDao();
	List<Student> students=studentDao.getAllStudents();
	boolean value=false;
	for(Student student:students) {
		if(student.getEmail().equals(email)) {
			value=true;
			break;
		}
	}
	
	if(value) {
//		email is present in the database 
//		if it is present only then we can check whether password is crct or not
		
	
//		fetch that student based on email;
		Student student=studentDao.getStudentByEmail(email);
		
		if(student.getPassword().equals(password)) {
//			is correct
//			login success
			
			List<Student> list=studentDao.getAllStudents();
			req.setAttribute("listofstudents",list );
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
			
		}else {
//			login failure
			req.setAttribute("message", "Invalid Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
	}else {
//		email is not present in the database
		req.setAttribute("message", "EmailDoesNotExist");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
	
	
	
	
}
}
