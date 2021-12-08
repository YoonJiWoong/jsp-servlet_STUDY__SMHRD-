package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class MemberDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	int cnt;
	ResultSet rs = null;
	MemberVO vo;
	boolean check;
	ArrayList<MemberVO> al = null;

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

	public int Join(String id,String nick, String pw, String age, String gender, String height, String kg,String bmi ) {

		try {

			connection();

			// 4. SQL�� �غ�
			String sql = "insert into MEMBER(id,pw,age,gender,height,kg,nick,bmi) values(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, age);
			pst.setString(4, gender);
			pst.setString(5, height);
			pst.setString(6, kg);
			pst.setString(7, nick);
			pst.setString(8, bmi);
			

			// 5. SQL�� ��� �� ó��
			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();

		}

		return cnt;

	}
	
	
		
		public MemberVO login(String email, String pw) {

			try {
				connection();

				String sql = "select * from member where id=? and pw=?";
				// �ʿ��Ѱ͸� ������ ���� ��õ

				// 3. sql ���� ��ü(PrepapredStatement) ��ü����

				pst = conn.prepareStatement(sql);

				// 4. ���ε� ���� ä���α�
				pst.setString(1, email);
				pst.setString(2, pw);

				// 5. sql�� ���� �� ��� ó��
				rs = pst.executeQuery();
				// ������ ��� Ŀ�� �޾ƿ���

				// rs.next() -> true / false
				if (rs.next()) {
					System.out.println("�α��μ���");

					String id= rs.getString("id"); 
					String get_pw= rs.getString("pw");  
					String height = rs.getString("height"); 
					String kg = rs.getString("kg"); 
					String age= rs.getString("age"); 
					String gender= rs.getString("gender"); 

					vo = new MemberVO(id, get_pw, height, kg, age, gender);

					// ���� ���� �����൵ ����� ����
//					session.setAttribute("id", value);
//					session.setAttribute("tel", value);
//					session.setAttribute("address", value);

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

			return vo;

		
		
		
	}
	
		public int Update(String pw, String age, String gender, String height, String kg, String id) {

			try {

				connection();

				// 4. SQL�� �غ�
				String sql = "update MEMBER set pw=?,age=?,gender=?,height=?,kg=? where id=?";
				
				pst = conn.prepareStatement(sql);
				
				pst.setString(1, pw);
				pst.setString(2, age);
				pst.setString(3, gender);
				pst.setString(4, height);
				pst.setString(5, kg);
				pst.setString(6, id);

				// 5. SQL�� ��� �� ó��
				cnt = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("��������");
				e.printStackTrace();
			} finally {

				close();

			}

			return cnt;

		}
		
		public ArrayList<MemberVO> selectAll() {

			al = new ArrayList<MemberVO>(); // ���࿡ ArrayList = null �̶�� �ߴٸ�!!
			// ������ �ʴµ� �̸� �������ʿ�� ������ �̷���?

			try {
				connection();

				String sql = "select id, pw, height, kg, age, gender FROM MEMBER";

				pst = conn.prepareStatement(sql);

				rs = pst.executeQuery();

				while (rs.next()) {

					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String height = rs.getString("height");
					String kg = rs.getString("kg");
					String age = rs.getString("age");
					String gender = rs.getString("gender");

					vo = new MemberVO(id, pw, height, kg, age, gender);

					al.add(vo);

				}

			} catch (Exception e) {
				System.out.println("��ȸ����");
				e.printStackTrace();
			} finally {
				close();
			}
			return al;
		}
		
		
		
		
		
		
		
		public int delete(String id) {

			try {
				connection();
				String sql = "DELETE FROM MEMBER  WHERE id = ?";

				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				cnt = pst.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("��������");
			} finally {
				close();
			}
			return cnt;
		}
		
		
		
	

}
