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
	
	Connection conn = null;
	ResultSet rs = null;
      
	String url = "jdbc:mysql://localhost:3306/sjb?serverTimezone=UTC";
	String id = "root";
	String pwd = "qwer1234";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pwd);
		Statement stmt = conn.createStatement();
 
		String sql = "SELECT id,pw,name FROM member "
				+" WHERE id='"+input_id+"' AND pw='"+input_pw+"'";
		
		System.out.println(sql);
		
		rs = stmt.executeQuery(sql);
	
		if(rs.next()) {
			session.setAttribute("name", rs.getString("name"));
			response.sendRedirect("login_ok.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}	

%>


</body>
</html>