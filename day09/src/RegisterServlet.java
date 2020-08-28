

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				response.sendRedirect("login.jsp");
			} else {
				response.sendRedirect("register.jsp");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
