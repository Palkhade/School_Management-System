<%@page import="schoolmanagment.dto.Teacher"%>
<%@page import="javax.persistence.EntityManager" %>
<%@page import="javax.persistence.EntityManagerFactory" %>
<%@page import="javax.persistence.EntityTransaction" %>
<%@page import="javax.persistence.Persistence" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import=" schoolmanagment.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher</title>
</head>
<body>
<%


Teacher t=(Teacher)session.getAttribute("Teacher");

%>
<form action="Updateteacher" method="post">
Id:<input type="number" value="<%=t.getId()%>" name="id">
Name:<input type="text" value="<%=t.getName()%>" name="name">
Subject:<input type="text" value="<%=t.getSubject()%>" name="subject">
Email:<input type="email" value="<%=t.getEmail()%>" name="email">
Password:<input type="hidden" value="<%=t.getPswd()%>" name="pswd">
Age:<input type="number" value="<%=t.getAge()%>" name="age">
<input type="submit">
</form>
</body>
</html>