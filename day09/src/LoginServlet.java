

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String input_id = request.getParameter("memberid");
		String input_pw = request.getParameter("pass1");
		
		Connection conn = null;
		ResultSet rs = null;
	      
		String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
		String id = "root";
		String pwd = "Dkagh1234.";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
	 
			String sql = "SELECT id,pw,name FROM member "
					+" WHERE id='"+input_id+"' AND pw='"+input_pw+"'";
			
			System.out.println(sql);
			
			rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				session.setAttribute("memberid", rs.getString("memberid"));
				session.setAttribute("pass1", rs.getString("pass1"));
				response.sendRedirect("list");	
			} else {
				response.sendRedirect("login.jsp");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}





