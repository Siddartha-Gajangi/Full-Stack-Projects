<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    form { max-width: 300px; margin: auto; }
    label { display: block; margin-top: 15px; }
    input { width: 100%; padding: 8px; margin-top: 5px; }
    button { margin-top: 15px; padding: 8px; }
    .error { color: red; text-align: center; }
   
    
  </style>
</head>
<body>
  <h2>Login</h2>
  <form action="LoginServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    
    <button type="submit">Login</button>
    <div class="error">
      <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </div>
  </form>
</body>
</html>
