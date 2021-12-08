package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	// text	-> 바이트코드로 변환 -> 직렬화
	// 바이트코드 -> text -> 역직렬화 
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String email =request.getParameter("email");
		String pw = request.getParameter("pw");
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 데이터베이스 연동 -> Connection 객체 생성
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			String sql = "select email, tel, address FROM WEB_MEMBER where EMAIL=? and pw=?";
			// 필요한것만 가지고 오기 추천
			
			// 3. sql 실행 객체(PrepapredStatement) 객체생성
			
			pst = conn.prepareStatement(sql);
			
			// 4. 바인드 변수 채워두기
			pst.setString(1, email);
			pst.setString(2, pw);
			
			// 5. sql문 실행 후 결과 처리
			rs = pst.executeQuery();
			// 데이터 담고 커리 받아오고
			
		
			
			// rs.next() -> true / false
			if(rs.next()) {
				System.out.println("로그인성공");
				
				String get_email = rs.getString("email");
				String get_tel = rs.getString("tel");
				String get_address = rs.getString("address");
				
				MemberVO vo = new MemberVO(get_email, get_tel, get_address);
				
				
				// 세션 객체 생성
				HttpSession session =request.getSession();
				
				// 세션 값 설정 - 객체던 뭐든 대부분 들어가?
				session.setAttribute("member", vo);
				
				
				
				response.sendRedirect("main.jsp");
				
				
				
				//따로 따로 적어줘도 상관은 없어
//				session.setAttribute("id", value);
//				session.setAttribute("tel", value);
//				session.setAttribute("address", value);
				
				
			}else {
				System.out.println("로그인실패");
				
			}
			//System.out.println("로그인 성공 유무 :"+check);
			
			
			

			
		} catch (Exception e) {
			System.out.println("로그인실패");
			
			e.printStackTrace();
		} finally {
			
			// 1. 지역변수
			// 2. 예외처리
			
			try {
				if(rs!=null) {
					rs.close();
					
				}
				
				if(pst!=null) {
					pst.close();
					
				}
				if(conn !=null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		


	
		
	}

}
