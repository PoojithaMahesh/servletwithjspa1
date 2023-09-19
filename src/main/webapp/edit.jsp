<%@page import="studentwithjsp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>

<%Student student=(Student)request.getAttribute("student"); %>


<form action="edit" method="post">
Id:<input type="number" name="id" required="required" value=<%=student.getId() %> readonly="readonly">
<br>
<br>
Name:<input type="text" name="name" required="required" value=<%=student.getName() %>>
<br>
<br>
Address:<input type="text" name="address" required="required" value=<%=student.getAddress() %>>
<br>
<br>
Phone:<input type="tel" name="phone" required="required" value=<%=student.getPhone() %>>
<br>
<br>
Email:<input type="email" name="email" required="required" value=<%=student.getEmail() %>>
<br>
<br>
Password:<input type="password" name="password" required="required" value=<%=student.getPassword() %>>
<br>
<br>
<input type="submit" value="EDIT">






</form>
</body>
</html>