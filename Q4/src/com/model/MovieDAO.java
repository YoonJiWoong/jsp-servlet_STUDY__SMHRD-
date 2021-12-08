package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieDAO {

	ResultSet rs = null;
	Connection conn = null;
	PreparedStatement pst = null;
	int cnt;

	
	public void connection() {

		try {

			// 1. 드라이버 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			// 2. 데이터 베이스 연결 객채(Connection) 생성
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}

	}

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}

			if (pst != null) {
				pst.close();

			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
	

	// 회원가입 기능(메서드)
	public int insert_member(MovieVO dto) {
		
		
		// 받아온 값을 db 테이블에 삽입
		try {

			connection();

			// 3. 실행할 sql문 정의 (실행할때마다 값이 달라지는 부분은? 적어주면 됨)
			String sql = "insert into movie_member values (?,?,?,?,?)";

			// 4. sql 실행객체(PreparedStatement)생성
			pst = conn.prepareStatement(sql);

			// 5. 바인드 변수 (?) 채우기
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPw());
			pst.setInt(3, dto.getAge());
			pst.setString(4, dto.getNick());
			pst.setString(5, dto.getTel());

			// 6. sql문 실행 후 결과처리
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("가입실패");

			e.printStackTrace();

		} finally {

			close();

		}
		return cnt;

	}

	
public String login_member(MovieVO vo) {
		
		String nick = null;

		try {
			connection();

			String sql = "select nick FROM movie_member where id=? and pw=?";
			// 필요한것만 가지고 오기 추천

			// 3. sql 실행 객체(PrepapredStatement) 객체생성

			pst = conn.prepareStatement(sql);

			// 4. 바인드 변수 채워두기
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());

			// 5. sql문 실행 후 결과 처리
			rs = pst.executeQuery();
			// 데이터 담고 커리 받아오고

			// rs.next() -> true / false
			if (rs.next()) {
				System.out.println("로그인성공");

				nick = rs.getString("nick");
			
			} else {
				System.out.println("로그인실패");

			}
			// System.out.println("로그인 성공 유무 :"+check);

		} catch (Exception e) {
			System.out.println("로그인실패");

			e.printStackTrace();
		} finally {

			close();

		}

		return nick;

		
	}
	
	
	
	
	
}
