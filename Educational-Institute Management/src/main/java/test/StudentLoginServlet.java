package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/student")
public class StudentLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String rollNo=req.getParameter("rollno");
		StudentBean sb= new StudentLoginDAO().login(rollNo);
		if(sb==null) {
			req.setAttribute("msg","Invalid Roll Number...<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
			
		}
		else {
			HttpSession hs= req.getSession();
			hs.setAttribute("sbean", sb);
			req.getRequestDispatcher("studentLoginSuccess.jsp").forward(req, res);
		}
	}
}
