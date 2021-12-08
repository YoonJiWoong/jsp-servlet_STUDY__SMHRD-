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

			// 1. ����̹� ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			// 2. ������ ���̽� ���� ��ä(Connection) ����
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������");
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
	

	// ȸ������ ���(�޼���)
	public int insert_member(String id, String pw) {
		
		
		// �޾ƿ� ���� db ���̺��� ����
		try {

			connection();

			String sql = "insert into testmember values (?,?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, id);
			pst.setString(2, pw);
		
		
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("���Խ���");

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
			// �ʿ��Ѱ͸� ������ ���� ��õ

			// 3. sql ���� ��ü(PrepapredStatement) ��ü����

			pst = conn.prepareStatement(sql);

			// 4. ���ε� ���� ä���α�
			pst.setString(1, id);
			pst.setString(2, pw);

			// 5. sql�� ���� �� ��� ó��
			rs = pst.executeQuery();
			// ������ ��� Ŀ�� �޾ƿ���

			// rs.next() -> true / false
			if (rs.next()) {
				System.out.println("�α��μ���");

				String getid = rs.getString("id");
				String getpw = rs.getString("pw");
				
				mdto = new MDTO(getid, getpw);
			
			} else {
				System.out.println("�α��ν���");

			}
			// System.out.println("�α��� ���� ���� :"+check);

		} catch (Exception e) {
			System.out.println("�α��ν���");

			e.printStackTrace();
		} finally {

			close();

		}

		return mdto;

		
	}
	
	
	
	
	

}