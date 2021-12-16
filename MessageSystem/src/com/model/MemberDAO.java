package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	int cnt;
	ResultSet rs = null;
	MemberVO vo = null;
	ArrayList<MemberVO> al = null;
	// null 값으로 하고 추가해주면 안되!(나중에 다시 new 써줘야...)
	// ArrayList는 이렇게 만들어야 한다!!! null 쓰면 안되고!!
	
	boolean check = false;
	
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
	public int join(String email, String pw, String tel, String address) {

		// 받아온 값을 db 테이블에 삽입
		try {

			connection();

			// 3. 실행할 sql문 정의 (실행할때마다 값이 달라지는 부분은? 적어주면 됨)
			String sql = "insert into web_member values (?,?,?,?)";

			// 4. sql 실행객체(PreparedStatement)생성
			pst = conn.prepareStatement(sql);

			// 5. 바인드 변수 (?) 채우기
			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, tel);
			pst.setString(4, address);

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

	// 로그인 기능
	public MemberVO login(String email, String pw) {

		try {
			connection();

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
			if (rs.next()) {
				System.out.println("로그인성공");

				String get_email = rs.getString("email");
				String get_tel = rs.getString("tel");
				String get_address = rs.getString("address");

				vo = new MemberVO(get_email, get_tel, get_address);

				// 따로 따로 적어줘도 상관은 없어
//				session.setAttribute("id", value);
//				session.setAttribute("tel", value);
//				session.setAttribute("address", value);

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

		return vo;

	}

	// 수정메소드
	// 사용자가 입력한 pw,tel,address
	// 로 테이블에 값을 수정
	public int update(String pw, String tel, String address, String email) {

		try {
			connection();

			String sql = "UPDATE WEB_MEMBER SET pw = ?, tel=?, address=? WHERE email =?";

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, tel);
			psmt.setString(3, address);
			psmt.setString(4, email);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("수정실패");
			e.printStackTrace();
		} finally {

			close();

		}

		return cnt;

	}

	public ArrayList<MemberVO> selectAll() {

		al = new ArrayList<MemberVO>(); // 만약에 ArrayList = null 이라고 했다면!!
		// 쓰지도 않는데 미리 생성할필요는 없으니 이렇게?

		try {
			connection();

			String sql = "select email, tel, address FROM WEB_MEMBER";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				String get_email = rs.getString("email");
				String get_tel = rs.getString("tel");
				String get_address = rs.getString("address");

				vo = new MemberVO(get_email, get_tel, get_address);

				al.add(vo);

			}

		} catch (Exception e) {
			System.out.println("조회실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	// 회원 삭제 메소드
	public int delete(String email) {

		try {
			connection();
			String sql = "DELETE FROM WEB_MEMBER  WHERE email = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		} finally {
			close();
		}
		return cnt;
	}

	//id 중복체크 메서드
	public boolean idCheck(String email) {
		
		
		try {
			connection();

			String sql = "select email FROM WEB_MEMBER where EMAIL=?";
			

			pst = conn.prepareStatement(sql);

			// 4. 바인드 변수 채워두기
			pst.setString(1, email);
			
			// 5. sql문 실행 후 결과 처리
			rs = pst.executeQuery();
		
			if (rs.next()) {
				// 입력한 이메일을 사용할 수 없을때
				
				check =true;
				

			} else {
				// 입력한 이메일을 사용할 수 있을때
				
				check=false; 
				//초기값은 false라 안적어도 되는데 직관적으로 보기 편하게
			}
			

		} catch (Exception e) {
			
			System.out.println("로그인실패");
			e.printStackTrace();
			
		} finally {

			close();

		}
		
		return check;
		
	}
	
}
