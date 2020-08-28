<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
%>
로그인 한 사람만 접속 가능한 페이지 <br>

<%= session.getAttribute("name") %> 

<form action="delete" method="post">
	<input type="hidden" name="memberid" 
		value="<%= session.getAttribute("user_id") %>">
	<input type="submit" value="탈퇴" >	 
</form>



</body>
</html>