package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/bal")
public class BalanceServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String accno=req.getParameter("accno");
		AccountBean ab=new BalanceDAO().retrieveBal(accno);
		if(ab==null)
		{
			req.setAttribute("msg","Invalid retrieval");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean",ab);
			req.getRequestDispatcher("Balance.jsp").forward(req, res);
		}
		
		
		
	}
}