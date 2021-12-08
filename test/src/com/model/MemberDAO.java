package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class MemberDAO {
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt;
	MemberVO vo = null;
	
	// ȸ������ ���(�޼���)
	public int join (String email,String pw,String tel, String address)	{
		
		
		// �޾ƿ� ���� db ���̺� ����
		try {
			// 1. ����̹� ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String password="hr";
			// 2. ������ ���̽� ���� ��ä(Connection) ����
			conn = DriverManager.getConnection(url,user,password);
			
			// 3. ������ sql�� ���� (�����Ҷ����� ���� �޶����� �κ���? �����ָ� ��)
			String sql = "insert into web_member values (?,?,?,?)";
			
			// 4. sql ���ఴü(PreparedStatement)����
			pst = conn.prepareStatement(sql);
			
			// 5. ���ε� ���� (?) ä���
			pst.setString(1,email);
			pst.setString(2,pw);
			pst.setString(3,tel);
			pst.setString(4,address);
			
			// 6.  sql�� ���� �� ���ó��
			cnt = pst.executeUpdate();
			
		}catch (Exception e) {
				System.out.println("���Խ���");
				
				e.printStackTrace();
				
			
			
			
			
		} finally {
			
			try {
				pst.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
			
			
		}
		return cnt;
		
	}
	
	// �α��� ���
	public MemberVO login(String email, String pw) {
		
		
		try {
			// 1. ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. �����ͺ��̽� ���� -> Connection ��ü ����
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

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
			if(rs.next()) {
				System.out.println("�α��μ���");
				
				String get_email = rs.getString("email");
				String get_tel = rs.getString("tel");
				String get_address = rs.getString("address");
				
				vo = new MemberVO(get_email, get_tel, get_address);
				
				
				
				
				//���� ���� �����൵ ����� ����
//				session.setAttribute("id", value);
//				session.setAttribute("tel", value);
//				session.setAttribute("address", value);
				
				
			}else {
				System.out.println("�α��ν���");
				
			}
			//System.out.println("�α��� ���� ���� :"+check);
			
			
			

			
		} catch (Exception e) {
			System.out.println("�α��ν���");
			
			e.printStackTrace();
		} finally {
			
			// 1. ��������
			// 2. ����ó��
			
			try {
				if(rs!=null) {
					rs.close();
					
				}
				
				if(pst!=null) {
					pst.close();
					
				}
				if(conn !=null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return vo;
		
		
	}
	
	

}
