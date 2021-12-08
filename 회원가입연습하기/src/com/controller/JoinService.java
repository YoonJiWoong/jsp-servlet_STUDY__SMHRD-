package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리퀘스트 리스폰스 매개인자
		
		//요청데이터 인코딩 방식 지정( 한글 인코딩)
		request.setCharacterEncoding("euc-kr");
		
		// 요청 데이터 받아주기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		//	System.out.println(eamil+","+pw+","+tel+","+address);
		
		try {
			//2. OracleDriver.class 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3. Oracle로 가서 DBID, DBPW를 인증
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("연결성공");
			}else {
				System.out.println("연결실패");
			}
			
			//4. SQL문 준비
			String sql = "insert into WEB_MEMBER  values(?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, tel);
			psmt.setString(4, address);
			
			int cnt = psmt.executeUpdate();
		
		
		
		if(cnt>0) {
			System.out.println("가입성공");
			
			// forward 방식으로 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			
			// 기억해야할 정보 세팅
			// request 영역에 기억해야할 데이터 설정
			request.setAttribute("email",email); // 위에 String 변수 설정한거 생각
			
			// 페이지 이동할시 request, response 객체 전달
			rd.forward(request, response); //맨 위에 request,response 찾아봐!
			
			
			// response.sendRedirect("join_success.jsp?email="+email);
			// 쿼리스트링 방식으로 데이터 전송 -> 받을때는 getParameter();
			
		}else {
			System.out.println("가입실패");
			response.sendRedirect("main.jsp");
			
			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}




		
	


