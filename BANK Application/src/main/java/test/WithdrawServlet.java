package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String accno=req.getParameter("accno");
		Double amt=Double.parseDouble(req.getParameter("amt"));
		int k=new WithdrawDAO().withdraw(accno, amt);
	    if(k==-1)
	    {
	    	
	    	req.setAttribute("msg","Insufficent balance");
	    	req.getRequestDispatcher("Msg.jsp").forward(req, res);
	    }
	    else if(k==1)
	    {
	    	req.setAttribute("msg","Amount Withdrawal successfully..");
          req.getRequestDispatcher("withdraw.jsp").forward(req, res);	    	
	    	    	
	    }	
	    else if(k==-2)
	    {
	    	req.setAttribute("msg","Account not found");
	    	req.getRequestDispatcher("Msg.jsp").forward(req, res);
	    }
	    
	}
		
	}