<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
StudentBean sb = (StudentBean)request.getAttribute("sbean");
out.println("Page belongs to Admin:"+ab.getfName()+"<br>");
out.println("RollNo:"+sb.getRollNo()+"<br>"
		+"CoreJava:"+sb.getMk().getCoreJava()+"<br>"
		+"AdvJava:"+sb.getMk().getAdvJava()+"<br>"
		+"UI:"+sb.getMk().getUi()+"<br>"
		+"DB:"+sb.getMk().getDb()+"<br>"
		+"Tools:"+sb.getMk().getTools()+"<br>");
%>
<a href="edit?rollno=<%= sb.getRollNo()%>">EditMarks</a>
<a href="student.html">AddStudent</a>
<a href="view">ViewAllStudends</a>
<a href="logout">Logout</a>

</body>
</html>