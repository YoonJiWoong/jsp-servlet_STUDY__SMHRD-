package test111;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class MDAO {
	
	
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
	public int insert_member(String id, String pw) {
		
		
		// 받아온 값을 db 테이블에 삽입
		try {

			connection();

			String sql = "insert into testmember values (?,?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, id);
			pst.setString(2, pw);
		
		
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("가입실패");

			e.printStackTrace();

		} finally {

			close();

		}
		return cnt;

	}

	
	public MDTO login_member(String id, String pw) {
		
		MDTO mdto= null; 

		try {
			connection();

			String sql = "select * FROM testmember where id=? and pw=?";
			// 필요한것만 가지고 오기 추천

			// 3. sql 실행 객체(PrepapredStatement) 객체생성

			pst = conn.prepareStatement(sql);

			// 4. 바인드 변수 채워두기
			pst.setString(1, id);
			pst.setString(2, pw);

			// 5. sql문 실행 후 결과 처리
			rs = pst.executeQuery();
			// 데이터 담고 커리 받아오고

			// rs.next() -> true / false
			if (rs.next()) {
				System.out.println("로그인성공");

				String getid = rs.getString("id");
				String getpw = rs.getString("pw");
				
				mdto = new MDTO(getid, getpw);
			
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

		return mdto;

		
	}
	
	
	
	
	

}
