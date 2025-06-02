<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Employee</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    form { max-width: 600px; margin: auto; }
    label { display: block; margin-top: 10px; }
    input, select, textarea { width: 100%; padding: 8px; margin-top: 5px; }
    button { margin-top: 15px; padding: 8px 12px; }
    .error { color: red; }
  </style>
  <script>
    function generateEmployeeID() {
      var letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      var idPart = "";
      for (var i = 0; i < 5; i++) {
        idPart += letters.charAt(Math.floor(Math.random() * letters.length));
      }
      var digit = Math.floor(Math.random() * 9) + 1;
      return idPart + digit;
    }
    
    function generateLoginID() {
      var firstName = document.getElementById('firstName').value.trim();
      var lastName = document.getElementById('lastName').value.trim();
      if (firstName && lastName) {
        var base = firstName.charAt(0).toLowerCase() + lastName.toLowerCase();
        if (base === "ajohnson") {
          base += Math.floor(100 + Math.random() * 900);
        }
        document.getElementById('loginId').value = base;
      }
    }
    
    window.onload = function() {
      document.getElementById('employeeId').value = generateEmployeeID();
      document.getElementById('firstName').addEventListener('blur', generateLoginID);
      document.getElementById('lastName').addEventListener('blur', generateLoginID);
    };
    
    function parseDOB(input) {
      var months = { "Jan":0, "Feb":1, "Mar":2, "Apr":3, "May":4, "Jun":5,
                     "Jul":6, "Aug":7, "Sep":8, "Oct":9, "Nov":10, "Dec":11 };
      var parts = input.split("-");
      if(parts.length !== 3) return null;
      var day = parseInt(parts[0], 10);
      var mon = parts[1];
      var year = parseInt(parts[2], 10);
      if(months[mon] === undefined) return null;
      return new Date(year, months[mon], day);
    }
    
    function calculateAge(dob) {
      var diff = Date.now() - dob.getTime();
      var ageDt = new Date(diff);
      return Math.abs(ageDt.getUTCFullYear() - 1970);
    }
    
    function validateForm() {
      var dobInput = document.getElementById('dob').value.trim();
      var dob = parseDOB(dobInput);
      if (!dob) {
        alert("Invalid Date of Birth format. Please use DD-Mon-YYYY.");
        return false;
      }
      if (calculateAge(dob) < 18) {
        alert("Employee must be at least 18 years old.");
        return false;
      }
      var fileInput = document.getElementById('idProof');
      if (fileInput.files.length == 0) {
        alert("Please upload your ID Proof.");
        return false;
      }
      var file = fileInput.files[0];
      if (file.type !== "application/pdf") {
        alert("Only PDF files allowed.");
        return false;
      }
      if (file.size < 10240 || file.size > 1048576) {
        alert("File size must be between 10KB and 1MB.");
        return false;
      }
      return true;
    }
  </script>
</head>
<body>
  <h2>Add New Employee</h2>
  <form action="EmployeeServlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
    <label for="employeeId">Employee ID:</label>
    <input type="text" id="employeeId" name="employeeId" readonly>
    
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required>
    
    <label for="middleName">Middle Name:</label>
    <input type="text" id="middleName" name="middleName">
    
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required>
    
    <label for="loginId">Login ID:</label>
    <input type="text" id="loginId" name="loginId" readonly>
    
    <label for="dob">Date of Birth (DD-Mon-YYYY):</label>
    <input type="text" id="dob" name="dob" placeholder="DD-Mon-YYYY" required>
    <small>Use date picker or manual entry</small>
    
    <label for="department">Department:</label>
    <select id="department" name="department" required>
      <option value="">--Select Department--</option>
      <option value="Engineering">Engineering</option>
      <option value="Support">Support</option>
      <option value="HR">HR</option>
      <option value="Finance">Finance</option>
    </select>
    
    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required>
    
    <label for="permAddress">Permanent Address:</label>
    <textarea id="permAddress" name="permAddress" required></textarea>
    
    <label for="currAddress">Current Address:</label>
    <textarea id="currAddress" name="currAddress" required></textarea>
    
    <label for="idProof">Upload ID Proof (PDF, 10KB - 1MB):</label>
    <input type="file" id="idProof" name="idProof" accept="application/pdf" required>
    
    <button type="submit">Submit</button>
  </form>
</body>
</html>
