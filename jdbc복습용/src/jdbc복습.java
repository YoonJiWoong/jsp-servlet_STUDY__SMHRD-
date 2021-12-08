
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc복습 {

	public static void main(String[] args) {
		
		// 현재 가입되어 있는 모든 회원의 정보 출력 (콘솔)
		// JDBC_member 테이블에 모든 정보 출력 ->조건x
		
		ResultSet rs = null; // boolean
		PreparedStatement psmt = null;
		Connection conn = null;
		
		// try-catch : 예외처리(런타임 오류)
		try {
			// 실행할 코드
			// 1. 드라이버 로드 -> ClassNotFoundException
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			// 다른 서버 수정할때는... / 포트번호 / 
			String dbid = "hr"; // id
			String dbpw = "hr"; // pw

			// 2. 데이터 베이스 연결 (Connection)객체 생성
			 conn= DriverManager.getConnection(url,dbid,dbpw);
			// java.sql 에 있는 거 임포트
			// sqlexception -> conn 안됨 
			
			String sql = "select * from jdbc_member"; // ; 없이 작성
			// 3. sql 실행 /준비(PreparedStatement)  객체 생성
			psmt=conn.prepareStatement(sql);
			
			// excuteUpdate() : insert, delete, update -> 테이블에 변화 O
			// -> 반환값 (int) -> 몇개의 행에서 변화가 일어났는지
			// excuteQuery() : select -> 테이블에 변화x
			// -> 반환값 (ResultSet(Object)) -> select문 실행시 결과값 + 커서
			// next() : 커서를 한칸 움직임(다음 행을 가리킴)
			// -> 커서가 가리키는 행에 값이 있는지 없는지를 판단 -> 있으면 true반환 / 없으면 false 반환
			
			
			// 4. sql 문 실행
			 rs = psmt.executeQuery(); //임폴트
			
			// executeUpdate()-> 정수형, 영향을 받은 행의 수, 영향받으면 항상 0보다 커
			// insert, delete, update -> 테이블 상에서 변화
			// select는 변화 없어!! -> 읽어만 오면 된다.
			
			// executeQuery() -> ResultSet (Object)가 반환된다.
			// ex) JDBC_Member 테이블이 있다면... 표가 반환된다고 생각하면됨.
			// 컬럼을 가르키는 커서가 있어 - > 행의 있는 값 하나하나 가져온다?
			// 행이 하나하나 가르킬려면 next() 라는 메소드가 있어
			// 1. 커서가 1칸 움직임
			// 2. 현재 가리키고 있는 행에 값이 있는지 없는지를 판단해준다. 0아님 1 그래서 boolean 반환 *중요*
			// 있으면 true 그리고 값들을 읽어온다. 그리고 다음에 값이 있으면 또 반복
			// 값이 없을떄까지 반복하다가  확인하고 없으면 false
			
			
			//5. 값을 출력
			
			while(rs.next()) { // rs.next 자체가 true 나 false
				// 각각의 컬럼값 읽어오기
				String id = rs.getString(1); // 컬럼은 순서(1부터 시작) 지정 / 첫번째 가져오겠다. 여기선 id
				String pw =rs.getString("pw"); // 컬럼 이름(String)지정해서 가지고 오기
				String nick =rs.getString(3);
				
				// int a = rs.getInt(1) -> 정수형값 가지고 올때
				// select nick 이라고 하면 닉네임 가져와도 rs.getString(1) 써야
				
				System.out.println("id :" +id);
				System.out.println("pw :" +pw);
				System.out.println("nick :" +nick);
				System.out.println("==================");
			}
			
			
		} catch (Exception e) {
			// try 문 안에서 발생한 예외 상황에 대한 처리
			e.printStackTrace();
		} finally {
			// try 문안에서 발생한 예외 상황에 대한 처리
			// 생성한 순서 반대로 닫아줘야
			// 6. 사용한 객체 닫기 (자원반환)
			try {
				
				// 생성한 역순으로 꼭!!
				rs.close(); // 객체생성이 되지 않은 경우 -> 위쪽에서 예외상황 발생 
							// -> close() 호출x -> 런타임 오류
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// 오토 커밋된다! db에서 커밋누르고!!
		
		
		
		
	}

}
