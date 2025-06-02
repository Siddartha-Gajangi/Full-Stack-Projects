<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employee Details</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
  </style>
</head>
<body>
<%
  Employee emp = (Employee) request.getAttribute("employee");
  if(emp != null) {
%>
  <h2>Employee Details</h2>
  <p><strong>Employee ID:</strong> <%= emp.getEmployeeId() %></p>
  <p><strong>First Name:</strong> <%= emp.getFirstName() %></p>
  <p><strong>Middle Name:</strong> <%= emp.getMiddleName() %></p>
  <p><strong>Last Name:</strong> <%= emp.getLastName() %></p>
  <p><strong>Login ID:</strong> <%= emp.getLoginId() %></p>
  <p><strong>Date of Birth:</strong> <%= emp.getDob() %></p>
  <p><strong>Department:</strong> <%= emp.getDepartment() %></p>
  <p><strong>Salary:</strong> <%= emp.getSalary() %></p>
  <p><strong>Permanent Address:</strong> <%= emp.getPermAddress() %></p>
  <p><strong>Current Address:</strong> <%= emp.getCurrAddress() %></p>
  <p><strong>ID Proof File:</strong> <%= emp.getIdProof() %></p>
<%
  } else {
%>
  <p>Employee not found.</p>
<%
  }
%>
</body>
</html>
