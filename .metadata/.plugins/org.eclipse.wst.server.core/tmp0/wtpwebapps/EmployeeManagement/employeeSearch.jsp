<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.example.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employee Search</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    .container { width: 90%; margin: auto; }
    .search-filters { margin-bottom: 20px; }
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
    th { background-color: #f4f4f4; }
  </style>
</head>
<body>
  <div class="container">
    <h2>Employee Search</h2>
    <div>
      <a href="employeeAdd.jsp">Add New Employee</a>
    </div>
    
    <div class="search-filters">
      <h3>Search Filters</h3>
      <form action="EmployeeServlet" method="get">
        <label for="searchId">Employee ID:</label>
        <input type="text" id="searchId" name="searchId">
        <label for="searchFirstName">First Name:</label>
        <input type="text" id="searchFirstName" name="searchFirstName">
        <label for="searchLastName">Last Name:</label>
        <input type="text" id="searchLastName" name="searchLastName">
        <label for="searchDept">Department:</label>
        <select id="searchDept" name="searchDept">
          <option value="">--All Departments--</option>
          <option value="Engineering">Engineering</option>
          <option value="Support">Support</option>
          <option value="HR">HR</option>
          <option value="Finance">Finance</option>
        </select>
        <button type="submit">Search</button>
      </form>
    </div>
    
    <h3>Search Results</h3>
    <table>
      <thead>
        <tr>
          <th>Employee ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Department</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
      <% List<Employee> employees = (List<Employee>) request.getAttribute("employeeList");
         if (employees != null) {
           for (Employee emp : employees) { %>
          <tr>
            <td><%= emp.getEmployeeId() %></td>
            <td><%= emp.getFirstName() %></td>
            <td><%= emp.getLastName() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><a href="EmployeeServlet?action=view&employeeId=<%= emp.getEmployeeId() %>">View</a></td>
          </tr>
      <%   }
         } %>
      </tbody>
    </table>
  </div>
</body>
</html>
