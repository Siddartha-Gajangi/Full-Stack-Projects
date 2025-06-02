<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
StudentBean sb=(StudentBean)session.getAttribute("sbean");
	out.println(sb.getRollNo()+"&nbsp&nbsp"
            +sb.getName()+"&nbsp&nbsp"
            +sb.getCourse()+"&nbsp&nbsp"
            +sb.getTotMarks()+"&nbsp&nbsp"
            +sb.getPer()+"&nbsp&nbsp"
            +sb.getResult()+"&nbsp&nbsp"+
            "<a href='studentViewMarks.jsp?rollno="+sb.getRollNo()+"'>ViewMarksiiddds</a><br>");	


%>
<a href="studentViewMarks.jsp?rollno=<%= sb.getRollNo() %>">View Marks</a>
<a href="studentLogout.jsp">Logout</a>
</body>
</html>