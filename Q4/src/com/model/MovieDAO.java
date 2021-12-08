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
	public int insert_member(MovieVO dto) {
		
		
		// �޾ƿ� ���� db ���̺��� ����
		try {

			connection();

			// 3. ������ sql�� ���� (�����Ҷ����� ���� �޶����� �κ���? �����ָ� ��)
			String sql = "insert into movie_member values (?,?,?,?,?)";

			// 4. sql ���ఴü(PreparedStatement)����
			pst = conn.prepareStatement(sql);

			// 5. ���ε� ���� (?) ä���
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPw());
			pst.setInt(3, dto.getAge());
			pst.setString(4, dto.getNick());
			pst.setString(5, dto.getTel());

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

	
public String login_member(MovieVO vo) {
		
		String nick = null;

		try {
			connection();

			String sql = "select nick FROM movie_member where id=? and pw=?";
			// �ʿ��Ѱ͸� ������ ���� ��õ

			// 3. sql ���� ��ü(PrepapredStatement) ��ü����

			pst = conn.prepareStatement(sql);

			// 4. ���ε� ���� ä���α�
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());

			// 5. sql�� ���� �� ��� ó��
			rs = pst.executeQuery();
			// ������ ��� Ŀ�� �޾ƿ���

			// rs.next() -> true / false
			if (rs.next()) {
				System.out.println("�α��μ���");

				nick = rs.getString("nick");
			
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

		return nick;

		
	}
	
	
	
	
	
}