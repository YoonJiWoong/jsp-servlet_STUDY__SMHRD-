package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void conn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_5_1025";
			String db_pw = "smhrd5";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SensorVO update(int mysensor) {
		SensorVO vo = null;
		conn();
		String sql1 = "update arduinosensor set mysensor = ?";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, mysensor);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		vo = getSensor();
		return vo;
	}
	
	public SensorVO update2(int count, String s_id) {
		SensorVO vo = null;
		conn();
		System.out.println("디비 접속 성공");
//		String sql1 = "update history set r_count =? where id='A' and s_id =?";
		String sql1 = "update history set r_count =? where id='A' and s_id =?";
		
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, count);
			psmt.setString(2, s_id);
			System.out.println("psmt 준비완료");
			result = psmt.executeUpdate();
			System.out.println("update 실행");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(result+"개 변형");
		
		return vo;
	}
	
	
	
	
	
	

	public SensorVO getSensor() {
		SensorVO vo = null;
		conn();
		System.out.println("디비 접속 성공  get sensor");
		String sql = "select * from arduinosensor";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int mysensor = rs.getInt(1);
				vo = new SensorVO(mysensor);
			}
			System.out.println("select 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

}
