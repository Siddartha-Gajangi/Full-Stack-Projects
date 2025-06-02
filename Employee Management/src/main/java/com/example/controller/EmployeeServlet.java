package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.model.Employee;

import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

@jakarta.servlet.annotation.MultipartConfig(fileSizeThreshold = 10240, maxFileSize = 1048576, maxRequestSize = 1048576)
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy"); 
    
    @Override
    public void init() throws ServletException {
        super.init();
        if(getServletContext().getAttribute("employeeList") == null) {
            List<Employee> employeeList = new ArrayList<>();
            getServletContext().setAttribute("employeeList", employeeList);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null) {
            if(action.equals("view")) {
                String employeeId = request.getParameter("employeeId");
                Employee emp = findEmployee(employeeId);
                request.setAttribute("employee", emp);
                RequestDispatcher rd = request.getRequestDispatcher("employeeView.jsp");
                rd.forward(request, response);
                return;
            } else if(action.equals("edit")) {
                String employeeId = request.getParameter("employeeId");
                Employee emp = findEmployee(employeeId);
                request.setAttribute("employee", emp);
                RequestDispatcher rd = request.getRequestDispatcher("employeeEdit.jsp");
                rd.forward(request, response);
                return;
            } else if(action.equals("delete")) {
                String employeeId = request.getParameter("employeeId");
                deleteEmployee(employeeId);
            } else if(action.equals("history")) {
                request.setAttribute("employeeId", request.getParameter("employeeId"));
                RequestDispatcher rd = request.getRequestDispatcher("employeeHistory.jsp");
                rd.forward(request, response);
                return;
            }
        }
        
        List<Employee> employeeList = (List<Employee>) getServletContext().getAttribute("employeeList");
        String searchId = request.getParameter("searchId");
        String searchFirstName = request.getParameter("searchFirstName");
        String searchLastName = request.getParameter("searchLastName");
        String searchLoginId = request.getParameter("searchLoginId");
        String dobStart = request.getParameter("dobStart");
        String dobEnd = request.getParameter("dobEnd");
        String searchDept = request.getParameter("searchDept");
        
        List<Employee> results = new ArrayList<>();
        for(Employee emp : employeeList) {
            boolean match = true;
            if(searchId != null && !searchId.trim().isEmpty() &&
               !emp.getEmployeeId().equalsIgnoreCase(searchId.trim())) {
                match = false;
            }
            if(searchFirstName != null && !searchFirstName.trim().isEmpty() &&
               !emp.getFirstName().equalsIgnoreCase(searchFirstName.trim())) {
                match = false;
            }
            if(searchLastName != null && !searchLastName.trim().isEmpty() &&
               !emp.getLastName().equalsIgnoreCase(searchLastName.trim())) {
                match = false;
            }
            if(searchLoginId != null && !searchLoginId.trim().isEmpty() &&
               !emp.getLoginId().equalsIgnoreCase(searchLoginId.trim())) {
                match = false;
            }
            try {
                if(dobStart != null && !dobStart.trim().isEmpty()){
                    Date startDate = sdf.parse(dobStart.trim());
                    Date empDob = sdf.parse(emp.getDob());
                    if(empDob.before(startDate)){
                        match = false;
                    }
                }
                if(dobEnd != null && !dobEnd.trim().isEmpty()){
                    Date endDate = sdf.parse(dobEnd.trim());
                    Date empDob = sdf.parse(emp.getDob());
                    if(empDob.after(endDate)){
                        match = false;
                    }
                }
            } catch(ParseException e) {
                
            }
            if(searchDept != null && !searchDept.trim().isEmpty() &&
               !emp.getDepartment().equalsIgnoreCase(searchDept.trim())){
                match = false;
            }
            if(match) {
                results.add(emp);
            }
        }
        request.setAttribute("employeeList", results);
        RequestDispatcher rd = request.getRequestDispatcher("employeeSearch.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && action.equals("deleteSelected")) {
            String[] empIds = request.getParameterValues("empIds");
            if(empIds != null) {
                for(String id : empIds) {
                    deleteEmployee(id);
                }
            }
            response.sendRedirect("EmployeeServlet");
            return;
        } else {
           
            String employeeId = request.getParameter("employeeId");
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String loginId = request.getParameter("loginId");
            String dob = request.getParameter("dob");
            String department = request.getParameter("department");
            String salary = request.getParameter("salary");
            String permAddress = request.getParameter("permAddress");
            String currAddress = request.getParameter("currAddress");
            
            Part filePart = request.getPart("idProof");
            String fileName = "";
            if(filePart != null) {
                fileName = getFileName(filePart);
                
            }
            
            Employee emp = new Employee();
            emp.setEmployeeId(employeeId);
            emp.setFirstName(firstName);
            emp.setMiddleName(middleName);
            emp.setLastName(lastName);
            emp.setLoginId(loginId);
            emp.setDob(dob);
            emp.setDepartment(department);
            emp.setSalary(salary);
            emp.setPermAddress(permAddress);
            emp.setCurrAddress(currAddress);
            emp.setIdProof(fileName);
            
            List<Employee> employeeList = (List<Employee>) getServletContext().getAttribute("employeeList");
            employeeList.add(emp);
            response.sendRedirect("employeeSearch.jsp");
        }
    }
    
    private Employee findEmployee(String employeeId) {
        List<Employee> employeeList = (List<Employee>) getServletContext().getAttribute("employeeList");
        for(Employee emp : employeeList) {
            if(emp.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return emp;
            }
        }
        return null;
    }
    
    private void deleteEmployee(String employeeId) {
        List<Employee> employeeList = (List<Employee>) getServletContext().getAttribute("employeeList");
        employeeList.removeIf(emp -> emp.getEmployeeId().equalsIgnoreCase(employeeId));
    }
    
    private String getFileName(Part part) {
        for(String cd : part.getHeader("content-disposition").split(";")) {
            if(cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }
}
