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
<%}else{ %>
<h1><%="WELCOME TO STUDENT APPLICATION " %></h1>
<%} %>
<form action="signup">
Name:<input type="text" name="name" required="required">
<br>
<br>
Address:<input type="text" name="address" required="required">
<br>
<br>
Phone:<input type="tel" name="phone" required="required">
<br>
<br>
Email:<input type="email" name="email" required="required">
<br>
<br>
Password:<input type="password" name="password" required="required">
<br>
<br>
<input type="submit" value="Signup">



</form>
</body>
</html>