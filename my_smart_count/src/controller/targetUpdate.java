package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

@WebServlet("/targetUpdate")
public class targetUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession(); // 세션 객체 생성
		MemberVO vo = (MemberVO)session.getAttribute("member"); // 현재 로그인한 사용자의(수정전) 정보

		// 요청 데이터 받아주기
		// 로그인 정보
		// sysdate
		// 횟수들 String -> int
//		String push = request.getParameter("push");
		int push = Integer.parseInt(request.getParameter("push")) ;
		int sit = Integer.parseInt(request.getParameter("sit")) ;
		int pull = Integer.parseInt(request.getParameter("pull")) ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_a_5_1025";
			String password = "smhrd5";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			String sql = "";
			
			sql = "UPDATE event SET T_COUNT = ? WHERE S_ID = 'a0'";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, push);
			int cnt = psmt.executeUpdate();
			
			sql = "UPDATE event SET T_COUNT = ? WHERE S_ID = 'b0'";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sit);
			cnt = psmt.executeUpdate();
			
			sql = "UPDATE event SET T_COUNT = ? WHERE S_ID = 'c0'";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pull);
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
//				response.sendRedirect("Main.html");
				System.out.println("성공");
				response.sendRedirect("index2.jsp");
				
			}else {
				System.out.println("실패");
				response.sendRedirect("index2.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
