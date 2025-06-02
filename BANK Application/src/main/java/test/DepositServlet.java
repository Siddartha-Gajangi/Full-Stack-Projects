package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/dep")
public class DepositServlet extends HttpServlet
{

	 
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		String accno=req.getParameter("accno");
		Double amt=Double.parseDouble(req.getParameter("amt"));
	    int k=new DepositDAO().deposit(accno, amt);
	    if(k<0)
	    {
	    	
	    	req.setAttribute("msg","Invalid");
	    	req.getRequestDispatcher("Msg.jsp").forward(req, res);
	    }
	    else {
	    	req.setAttribute("msg","Amount deposited successfully");
	    	req.getRequestDispatcher("Deposit.jsp").forward(req, res);
	    }	
	}
	

}