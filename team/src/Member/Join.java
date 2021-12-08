package Member;

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

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		//JDBC
		//1. ojdbc6.jar 가져오기(WEB-INF->lib)
		
		try {
			//2. OracleDriver.class 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3. Oracle로 가서 DBID, DBPW를 인증
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("연결성공");
			}else {
				System.out.println("연결실패");
			}
			
			//4. SQL문 준비
			String sql = "insert into test_memver values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			
			//5. SQL문 명령 후 처리
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("회원가입성공");
				response.sendRedirect("Join.html");
			}else {
				System.out.println("회원가입실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			


			try {
				if (rs != null) {
					rs.close();
				}

				if (psmt != null) {
					psmt.close();

				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		
		
		
	}

}
