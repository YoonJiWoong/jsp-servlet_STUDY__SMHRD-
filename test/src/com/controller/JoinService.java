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
		
		Connection conn= null;
		PreparedStatement pst = null;
		
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
			// 1. 드라이버 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String password="hr";
			// 2. 데이터 베이스 연결 객채(Connection) 생성
			conn = DriverManager.getConnection(url,user,password);
			
			// 3. 실행할 sql문 정의 (실행할때마다 값이 달라지는 부분은? 적어주면 됨)
			String sql = "insert into web_member values (?,?,?,?)";
			
			// 4. sql 실행객체(PreparedStatement)생성
			pst = conn.prepareStatement(sql);
			
			// 5. 바인드 변수 (?) 채우기
			pst.setString(1,email);
			pst.setString(2,pw);
			pst.setString(3,tel);
			pst.setString(4,address);
			
			// 6.  sql문 실행 후 결과처리
			int cnt = pst.executeUpdate();
			
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
				System.out.println("가입실패");
				
				e.printStackTrace();
				
			
			
			
			
		} finally {
			
			try {
				pst.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
			
			
		}
		
		
		
		
		
		
		
	}

}
