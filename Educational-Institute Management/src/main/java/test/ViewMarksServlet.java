package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewm")
public class ViewMarksServlet extends HttpServlet
{
  @SuppressWarnings("unchecked")
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
  ServletException,IOException
  {
	  HttpSession hs = req.getSession(false);
	  if(hs==null) {
		  req.setAttribute("msg","Session Expired...<br>");
		  req.getRequestDispatcher("Msg.jsp").forward(req, res);
	  }else {
		 ArrayList<StudentBean> al = (ArrayList<StudentBean>)hs.getAttribute("alist");
		 String rNo = req.getParameter("rollno");
		 Iterator<StudentBean> it = al.iterator();
		 while(it.hasNext()) {
			StudentBean sb = (StudentBean)it.next();
			if(rNo.equals(sb.getRollNo())) {
				req.setAttribute("sbean", sb);
				req.getRequestDispatcher("viewMarks.jsp").forward(req, res);
				break;//stop the loop
			}//end of if
		 }//end of loop
	  }//end of else
  }
}
