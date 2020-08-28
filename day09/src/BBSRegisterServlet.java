

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BBSRegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String input_title = request.getParameter("title");
		String input_writer = request.getParameter("writer");
		String input_content = request.getParameter("content");
		
		Connection conn = null;
	    
		String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
		String id = "root";
		String pwd = "Dkagh1234.";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
	 
			SimpleDateFormat curdate = new SimpleDateFormat ( "yyyy/MM/dd");
			Date time = new Date();
			String time1 = curdate.format(time);
			
			SimpleDateFormat curtime = new SimpleDateFormat ( "HH:mm:ss");
			String time2 = curtime.format(time);
			
			String sql = "INSERT INTO bbs (title, content, writer, wdate, wtime) VALUES " + 
					" ('"+input_title+"','"+input_content+"','"+input_writer+"',"
							+ "'"+time1+"', '"+time2+"');";
			
			if(stmt.executeUpdate(sql)==1) {
				response.sendRedirect("../list");
			} else {
				response.sendRedirect("register.jsp");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
