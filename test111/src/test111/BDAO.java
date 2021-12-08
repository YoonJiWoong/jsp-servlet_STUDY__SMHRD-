package test111;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class BDAO {

	

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	BVO bvo = null;
	ArrayList<BVO> al = null;
	int cnt = 0;
	boolean check = false;
	
	
	public void connection() {
		//1. 드라이버 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
		
		
		//2.데이터베이스 연결 객체(Connection) 생성
		conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
	}
	public ArrayList<BVO> noContents() {

		al = new ArrayList<BVO>();
		
		try {
			connection();
			
			String sql = "Select board_sq,board_title, TO_CHAR(board_date, 'YYYY/MM/DD'),m_id from board";
			psmt	= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				int board_num = Integer.parseInt(rs.getString(1));
				String board_title = rs.getString(2);
				String board_date = rs.getString(3);
				String m_id = rs.getString(4);
				
				bvo = new BVO(board_num,board_title,board_date,m_id);
				al.add(bvo);
			}
			
		} catch (Exception e) {
				System.out.println("조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return al;
	}
	
	public BVO getContents(int board_num) {
		
		try {
			connection();
			
			String sql = "Select board_sq,board_title,board_contents ,TO_CHAR(board_date, 'YYYY/MM/DD'),m_id from board where board_sq=?";
			
			psmt	= conn.prepareStatement(sql);
			psmt.setInt(1, board_num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				board_num = rs.getInt(1);
				String board_title = rs.getString(2);
			 	String board_contents = rs.getString(3);
				String board_date = rs.getString(4);
				String m_id = rs.getString(5);
				
				bvo = new BVO(board_num,board_title,board_contents,board_date,m_id);
			
			}
			
		} catch (Exception e) {
				System.out.println("조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return bvo;
	}
	
	public int deleteServiceCenter(int board_num) {
		try {
			connection();
			
			String sql = "delete from ServiceCenter where board_sq=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board_num);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}finally {
			close();
			}
		return cnt;
	}
	
	
	
	
	
}
