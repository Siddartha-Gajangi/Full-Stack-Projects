package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/regg")
public class RegisterServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		res.setContentType("text/html");
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			RegisterBean rb=new RegisterBean();
			rb.setFname(req.getParameter("fname"));
			rb.setEmail(req.getParameter("mail"));
			rb.setUname(req.getParameter("uname"));
			String pw = req.getParameter("pwd");
			String cpw = req.getParameter("cpwd");
			if(pw.equals(cpw))
			{
				rb.setPassword(pw);
			}
			System.out.println("name: "+rb.getFname()+"\nmail:"+rb.getEmail()+"\nUname;"+rb.getUname()+"\npass:"+rb.getPassword());
			
			int k= new RegisterDAO().insert(rb);
			
			if(k>0)
			{
				hs.setAttribute("rbean", rb);
				res.getWriter().println("Register Successfulll");
				req.getRequestDispatcher("Login.html").include(req, res);
			}
			else
			{
				res.getWriter().println("Register UnSuccessfulll");
				req.getRequestDispatcher("Register.html").include(req, res);
			}
		}
				
	}

}