

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

import day09.BBSItem;


public class BBSReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		String input_no = request.getParameter("no");
		
		Connection conn = null;
		ResultSet rs = null;
	      
		String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
		String id = "root";
		String pwd = "Dkagh1234.";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
	 
			String sql = "SELECT * FROM bbs "
					+" WHERE seqno="+input_no;
			
			System.out.println(sql);
			
			rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				BBSItem bbsi = new BBSItem();
					
				bbsi.setSeqNo(rs.getInt("seqno"));
				bbsi.setTitle(rs.getString("title"));
				bbsi.setContent(rs.getString("content"));
				bbsi.setWriter(rs.getString("writer"));
				bbsi.setDate(rs.getDate("wdate"));
				bbsi.setTime(rs.getTime("wtime"));
				
				request.setAttribute("BBS_ITEM", bbsi);
				RequestDispatcher rd = request.getRequestDispatcher("read.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("../list");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}





