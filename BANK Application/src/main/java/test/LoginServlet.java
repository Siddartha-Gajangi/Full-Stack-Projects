package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String un=req.getParameter("uname");
		String pw=req.getParameter("pwd");
		
		RegisterBean rb=new LoginDAO().login(un,pw);
		
		if(rb==null)
		{
			req.setAttribute("msg","Invalid Login process..");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs= req.getSession();
			hs.setAttribute("rbean",rb);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
		}
		
	}

}