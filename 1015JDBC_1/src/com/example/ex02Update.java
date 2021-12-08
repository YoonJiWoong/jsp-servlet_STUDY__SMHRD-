package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex02Update")
public class ex02Update extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String select = request.getParameter("select");
		String data = request.getParameter("data");
		
		PreparedStatement psmt = null;

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid ="hr";
			String dbpw ="hr";
			
			Connection conn = DriverManager.getConnection(url,dbid,dbpw);
			String sql="";
			if(select.equals("PW")) {
                sql = "UPDATE JDBC_member SET pw = ? WHERE id = ?";
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1,data);
				psmt.setString(2,id);
				
			}else if(select.equals("NICK")) {
				
				sql = "UPDATE JDBC_member SET nick = ? WHERE id = ?";
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1,data);
				psmt.setString(2,id);
			}
			
			
			
			
			
			
			
			
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				
				response.sendRedirect("ex02UpdatePopup.html");
				
			}else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
