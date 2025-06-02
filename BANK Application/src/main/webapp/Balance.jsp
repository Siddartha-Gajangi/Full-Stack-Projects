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
AccountBean ab=(AccountBean)session.getAttribute("abean");
out.println("Balance:"+ab.getAmount());
%>
<h1>Banking Application</h1>
<a href="Balance.html">Balance</a>
<a href="Deposit.html">Deposit</a>
<a href="Withdraw.html">withdraw</a>
<a href="TransferMoney.html">TransferMoney</a>
<a href="CloseAccount.html">closeAccount</a>
<a href="About.html">About</a>
</body>
</html>