package test;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferMoneyServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String saccno=req.getParameter("saccno");
		String raccno=req.getParameter("raccno");
		Double amt=Double.parseDouble(req.getParameter("amt"));
		TransferMoneyBean tb=new TransferMoneyDAO().transferMoney(saccno,raccno,amt);
		
		if(tb==null)
	    {
			req.setAttribute("msg","Invalid Amount");
	          req.getRequestDispatcher("Msg.jsp").forward(req, res);	 
	    	
	    }
		else {
			req.setAttribute("msg","Amount transfered successfully");
			req.getRequestDispatcher("TransferMoney.jsp").forward(req, res);
		}
	    		
	}
}