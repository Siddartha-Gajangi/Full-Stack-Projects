<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<StudentBean> al = (ArrayList<StudentBean>)session.getAttribute("alist");
out.println("Page belongs to Admin:"+ab.getfName()+"<br>");
if(al.size()==0){
	out.println("No Students Available...<br>");
}else{
	Iterator<StudentBean> it = al.iterator();
	while(it.hasNext()){
		StudentBean sb = (StudentBean)it.next();
		out.println(sb.getRollNo()+"&nbsp&nbsp"
				+sb.getName()+"&nbsp&nbsp"+sb.getCourse()+"&nbsp&nbsp"
				+sb.getTotMarks()+"&nbsp&nbsp"+
				+sb.getPer()+"&nbsp&nbsp"+
				sb.getResult()+"&nbsp&nbsp"+
				"<a href='viewm?rollno="+sb.getRollNo()+"'>ViewMarks</a><br>");
	}
}
%>
</body>
</html>