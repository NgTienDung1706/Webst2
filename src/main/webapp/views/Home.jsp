<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.model.UserModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Welcome to Home Manager</h1>
    
    <% 
        UserModel user = (UserModel) session.getAttribute("account"); 
        if (user != null) {
    %>
        <p>Hello, <%= user.getUsername() %>!</p>
        <p>Your role ID is: <%= user.getRoleid() %></p>
    <% 
        } else { 
    %>
        <p>You are not logged in.</p>
    <% 
        } 
    %>

    <!-- Link to logout -->
    <a href="<%= request.getContextPath() %>/logout">Logout</a>
</body>
</html>