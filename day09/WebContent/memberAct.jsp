<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String input_id = request.getParameter("memberid");
	String input_pw = request.getParameter("pass1");
	String input_name = request.getParameter("name");
	
	Connection conn = null;
    
	String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
	String id = "root";
	String pwd = "Dkagh1234.";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pwd);
		Statement stmt = conn.createStatement();
 
		String sql = "INSERT INTO member VALUES ('"+input_id
				+"', '"+input_pw+"', '"+input_name+"')";
		
		if(stmt.executeUpdate(sql)==1) {
			out.println("가입 성공");
		} else {
			out.println("가입 실패");
		}
		
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}	
%>


</body>
</html>