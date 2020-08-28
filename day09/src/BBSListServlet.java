

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day09.BBSItem;
public class BBSListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		ResultSet rs = null;
	      
		String url = "jdbc:mysql://localhost:3306/hwt?serverTimezone=UTC";
		String id = "root";
		String pwd = "Dkagh1234.";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
	 
			String sql = "SELECT * FROM bbs ORDER BY seqno DESC";
			
			rs = stmt.executeQuery(sql);
			ArrayList<BBSItem> bbsItemList = new ArrayList<BBSItem>();

			while(rs.next()) {
				BBSItem bbsi = new BBSItem();
				
				bbsi.setSeqNo(rs.getInt("seqno"));
				bbsi.setTitle(rs.getString("title"));
				bbsi.setContent(rs.getString("content"));
				bbsi.setWriter(rs.getString("writer"));
				bbsi.setDate(rs.getDate("wdate"));
				bbsi.setTime(rs.getTime("wtime"));
				bbsItemList.add(bbsi);
			}
		
			request.setAttribute("BBS_LIST", bbsItemList);
			RequestDispatcher rd = request.getRequestDispatcher("tables.jsp");
			rd.forward(request, response);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
    }
}
