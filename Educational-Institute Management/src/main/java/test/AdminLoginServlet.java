package test;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String uN=req.getParameter("uname");
		String pW=req.getParameter("pword");
		AdminBean ab= new AdminLoginDAO().login(uN, pW);
		if(ab==null) {
			 req.setAttribute("msg","Invalid Login process...<br>");
			 req.getRequestDispatcher("msg.jsp").forward(req,res);
			 
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("adminLoginSuccess.jsp").forward(req,res);
		}
	}
}
