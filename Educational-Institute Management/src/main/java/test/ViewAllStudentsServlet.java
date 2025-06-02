package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllStudentsServlet extends HttpServlet
{
   protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
   ServletException,IOException
   {
	   HttpSession hs = req.getSession(false);//Accessing Existing Session
	   if(hs==null) {
		   req.setAttribute("msg","Session Expired...<br>");
		   req.getRequestDispatcher("Msg.jsp").forward(req, res);
	   }else {
		   ArrayList<StudentBean> al = new ViewAllStudentsDAO().retrieve();
		   hs.setAttribute("alist", al);//List Object added to Session
		   req.getRequestDispatcher("viewAllStudents.jsp").forward(req, res);
	   }
   }
}
