<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"     import="test.*"%>
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
%>
<form action="update" method="post">
<input type="hidden" name="rollno" value=<%= sb.getRollNo() %>>
CoreJava:<input type="text" name="corejava" value=<%= sb.getMk().getCoreJava() %>><br>
AdvJava:<input type="text" name="advjava" value=<%= sb.getMk().getAdvJava() %>><br>
UI:<input type="text" name="ui" value=<%= sb.getMk().getUi() %>><br>
DB:<input type="text" name="db" value=<%= sb.getMk().getDb() %>><br>
Tools:<input type="text" name="tools" value=<%= sb.getMk().getTools() %>><br>
<input type="submit" value="updateMarks">
</form>
</body>

</html>