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
StudentBean sb = (StudentBean) session.getAttribute("sbean");
out.println("Welcome Student: " + sb.getName());
%>
<a href="viewDetails.jsp">View Details</a>
<a href="studentLogout.jsp">LogOut</a>
</body>
</html>