package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;







public class MemberDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt;
	MemberVO vo;
	GraphVo vo1;
	
	boolean check;
	ArrayList<MemberVO> al = null;
	ArrayList<GraphVo> al1 = null;

	public void connection() {

		try {

			// 1. ����̹� ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_a_5_1025";
			String password = "smhrd5";
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

	public int Join(String id, String pw, String nick, String height, String kg, String gender, String age, String bmi) {

		try {

			connection();

			// 4. SQL�� �غ�
			String sql = "insert into MEMBER(id,pw,nick,height,kg,gender,age,bmi) values(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, nick);
			pst.setString(4, height);
			pst.setString(5, kg);
			pst.setString(6, gender);
			pst.setString(7, age);
			pst.setString(8, bmi);

			// 5. SQL�� ���� �� ó��
			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();

		}

		return cnt;

	}
	
	
		
		public MemberVO login(String id, String pw) {

			try {
				connection();

				String sql = "select * from member where id=? and pw=?";
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

					String get_id= rs.getString("id"); 
					String get_pw= rs.getString("pw");
					String nick = rs.getString("nick");
					String height = rs.getString("height"); 
					String kg = rs.getString("kg"); 
					String gender = rs.getString("gender");
					String age= rs.getString("age"); 
					String bmi= rs.getString("bmi"); 

					vo = new MemberVO(get_id, get_pw, nick, height, kg, gender, age, bmi);

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
	
		public int Update(String pw, String age, String gender, String height, String kg, String id, String bmi) {

			try {

				connection();

				// 4. SQL�� �غ�
				String sql = "update MEMBER set pw=?,age=?,gender=?,height=?,kg=?,bmi=? where id=?";
				
				pst = conn.prepareStatement(sql);
				
				pst.setString(1, pw);
				pst.setString(2, age);
				pst.setString(3, gender);
				pst.setString(4, height);
				pst.setString(5, kg);
				pst.setString(7, id);
				pst.setString(6, bmi);
				

				// 5. SQL�� ���� �� ó��
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

				String sql = "select id, pw,nick, height, kg, gender,age,bmi FROM MEMBER";

				pst = conn.prepareStatement(sql);

				rs = pst.executeQuery();

				while (rs.next()) {

					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String nick = rs.getString("nick");
					String height = rs.getString("height"); 
					String kg = rs.getString("kg"); 
					String gender = rs.getString("gender");
					String age= rs.getString("age"); 
					String bmi= rs.getString("bmi"); 

					vo = new MemberVO(id, pw, nick, height, kg, gender, age, bmi);

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
		
		
		public boolean idCheck(String id) {
			

			
			
			try {
				connection();

				String sql = "select id FROM MEMBER where id=?";
				

				pst = conn.prepareStatement(sql);

				// 4. ���ε� ���� ä���α�
				pst.setString(1, id);
				
				// 5. sql�� ���� �� ��� ó��
				rs = pst.executeQuery();
			
				if (rs.next()) {
					// �Է��� �̸����� ����� �� ������
					
					check =true;
					

				} else {
					// �Է��� �̸����� ����� �� ������
					
					check=false; 
					//�ʱⰪ�� false�� ����� �Ǵµ� ���������� ���� ���ϰ�
				}
				

			} catch (Exception e) {
				
				System.out.println("�α��ν���");
				e.printStackTrace();
				
			} finally {

				close();

			}
			
			return check;
			
		
			
		}
		
		
		
		public ArrayList<GraphVo> R_COUNT(String id) {
			
			al1 = new ArrayList<GraphVo>();

			try {
				connection();

				String sql = "select id,R_COUNT,day from history where id = ? ";
				// �ʿ��Ѱ͸� ������ ���� ��õ

				// 3. sql ���� ��ü(PrepapredStatement) ��ü����

				pst = conn.prepareStatement(sql);

				// 4. ���ε� ���� ä���α�
				pst.setString(1, id);
				

				// 5. sql�� ���� �� ��� ó��
				rs = pst.executeQuery();
				// ������ ��� Ŀ�� �޾ƿ���

				// rs.next() -> true / false
				while(rs.next()) {
					System.out.println("�������� ����");

					String get_id= rs.getString("id"); 
					int get_R_COUNT= rs.getInt("R_COUNT");
					String get_day= rs.getString("day");
					
					vo1 = new GraphVo(get_id, get_R_COUNT, get_day);

					
					al1.add(vo1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�������� ���ФФ�");

				e.printStackTrace();
			} finally {

				close();

			}
			System.out.println(al);
			return al1;


		}
		
		
		
		
		
		
	

}