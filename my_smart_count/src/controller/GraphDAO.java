package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GraphVo;

public class GraphDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	ArrayList<GraphVo> r_count = null;

	public void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_5_1025";
			String dbpw = "smhrd5";

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {
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

	public String[] get() {
		String event[] = new String[3];
		try {
			connection();
			// 1
			String sql = "SELECT T_COUNT FROM event WHERE S_ID = 'a0'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				event[0] = rs.getString(1);
			}
			// 2
			sql = "SELECT T_COUNT FROM event WHERE S_ID = 'b0'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				event[1] = rs.getString(1);
			}

			// 3
			sql = "SELECT T_COUNT FROM event WHERE S_ID = 'c0'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				event[2] = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return event;
	}
	
	public ArrayList<GraphVo> R_COUNT(String id, String sid) {
		try {
			r_count = new ArrayList<GraphVo>();
			connection();

			String sql = "select id,R_COUNT,day from history where id = ? and s_id Like ? order by day ";
			// �ʿ��Ѱ͸� ������ ���� ��õ

			// 3. sql ���� ��ü(PrepapredStatement) ��ü����

			psmt = conn.prepareStatement(sql);

			// 4. ���ε� ���� ä���α�
			psmt.setString(1, id);
			psmt.setString(2, sid);
			

			// 5. sql�� ���� �� ��� ó��
			rs = psmt.executeQuery();
			// ������ ��� Ŀ�� �޾ƿ���

			// rs.next() -> true / false
			while(rs.next()) {
				System.out.println("�������� ����");

				String get_id= rs.getString("id"); 
				int get_R_COUNT= rs.getInt("R_COUNT");
				String get_day= rs.getString("day");
				
				r_count.add(new GraphVo(get_id, get_R_COUNT, get_day)) ;
				System.out.println(sid);
			}
			System.out.println("========================" + sid + "��==========================");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������� ���ФФ�");

			e.printStackTrace();
		} finally {

			close();

		}
		return r_count;

	}
	

}
