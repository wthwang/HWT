

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BBSDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String input_no = request.getParameter("no");
		
		
		Connection conn = null;
	    
		String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
		String id = "root";
		String pwd = "Dkagh1234.";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
	 
			String sql = "DELETE FROM bbs WHERE seqno='"+input_no+"'";
			
			if(stmt.executeUpdate(sql)==1) {
				response.sendRedirect("../list");
			} else {
				response.sendRedirect("../list");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
