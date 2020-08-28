

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BBSModifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String input_no = request.getParameter("no");
		String input_title = request.getParameter("title");
		String input_content = request.getParameter("content");
		
		Connection conn = null;
	    
		String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
		String id = "root";
		String pwd = "Dkagh1234.";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
	 
			String sql = "UPDATE bbs SET title='"+input_title
					+"',content='"+input_content+"' WHERE seqno="+input_no;
			
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
