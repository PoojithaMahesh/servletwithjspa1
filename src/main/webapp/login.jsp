<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message") ;%>
<%if(message!=null){ %>
<%=message %>
<%}else{ %>
<%="WELCOME BACK PLEASE LOGIN" %>
<%} %>

<form action="login" method="post">
Email:<input type="email" name="email" required="required">
<br>
<br>

Password:<input type="password" name="password" required="required">
<br>
<br>

<input type="submit" value="LOGIN">
</form>
</body>
</html>