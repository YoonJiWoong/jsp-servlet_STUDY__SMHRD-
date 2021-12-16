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
	// null ������ �ϰ� �߰����ָ� �ȵ�!(���߿� �ٽ� new �����...)
	// ArrayList�� �̷��� ������ �Ѵ�!!! null ���� �ȵǰ�!!
	
	boolean check = false;
	
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
	public int join(String email, String pw, String tel, String address) {

		// �޾ƿ� ���� db ���̺� ����
		try {

			connection();

			// 3. ������ sql�� ���� (�����Ҷ����� ���� �޶����� �κ���? �����ָ� ��)
			String sql = "insert into web_member values (?,?,?,?)";

			// 4. sql ���ఴü(PreparedStatement)����
			pst = conn.prepareStatement(sql);

			// 5. ���ε� ���� (?) ä���
			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, tel);
			pst.setString(4, address);

			// 6. sql�� ���� �� ���ó��
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("���Խ���");

			e.printStackTrace();

		} finally {

			close();

		}
		return cnt;

	}

	// �α��� ���
	public MemberVO login(String email, String pw) {

		try {
			connection();

			String sql = "select email, tel, address FROM WEB_MEMBER where EMAIL=? and pw=?";
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

				String get_email = rs.getString("email");
				String get_tel = rs.getString("tel");
				String get_address = rs.getString("address");

				vo = new MemberVO(get_email, get_tel, get_address);

				// ���� ���� �����൵ ����� ����
//				session.setAttribute("id", value);
//				session.setAttribute("tel", value);
//				session.setAttribute("address", value);

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

	// �����޼ҵ�
	// ����ڰ� �Է��� pw,tel,address
	// �� ���̺� ���� ����
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
			System.out.println("��ȸ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	// ȸ�� ���� �޼ҵ�
	public int delete(String email) {

		try {
			connection();
			String sql = "DELETE FROM WEB_MEMBER  WHERE email = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������");
		} finally {
			close();
		}
		return cnt;
	}

	//id �ߺ�üũ �޼���
	public boolean idCheck(String email) {
		
		
		try {
			connection();

			String sql = "select email FROM WEB_MEMBER where EMAIL=?";
			

			pst = conn.prepareStatement(sql);

			// 4. ���ε� ���� ä���α�
			pst.setString(1, email);
			
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
	
}
