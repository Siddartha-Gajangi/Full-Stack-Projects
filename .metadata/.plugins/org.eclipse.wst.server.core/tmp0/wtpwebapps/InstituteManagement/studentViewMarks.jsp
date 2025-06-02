<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
<%
StudentBean sb = (StudentBean) request.getAttribute("sbean");
    out.println("RollNo: " + sb.getRollNo() + "<br>"
            + "CoreJava: " + sb.getMk().getCoreJava() + "<br>"
            + "AdvJava: " + sb.getMk().getAdvJava() + "<br>"
            + "UI: " + sb.getMk().getUi() + "<br>"
            + "DB: " + sb.getMk().getDb() + "<br>"
            + "Tools: " + sb.getMk().getTools() + "<br>");
%>
<a href="StudentLogout.jsp">Logout</a>
</body>
</html>
