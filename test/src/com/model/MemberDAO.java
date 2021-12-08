package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class MemberDAO {
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt;
	MemberVO vo = null;
	
	// 회원가입 기능(메서드)
	public int join (String email,String pw,String tel, String address)	{
		
		
		// 받아온 값을 db 테이블에 삽입
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
			cnt = pst.executeUpdate();
			
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
		return cnt;
		
	}
	
	// 로그인 기능
	public MemberVO login(String email, String pw) {
		
		
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
				
				vo = new MemberVO(get_email, get_tel, get_address);
				
				
				
				
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
		
		return vo;
		
		
	}
	
	

}
