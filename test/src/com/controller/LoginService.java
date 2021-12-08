package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	// text	-> ����Ʈ�ڵ�� ��ȯ -> ����ȭ
	// ����Ʈ�ڵ� -> text -> ������ȭ 
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String email =request.getParameter("email");
		String pw = request.getParameter("pw");
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
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
				
				MemberVO vo = new MemberVO(get_email, get_tel, get_address);
				
				
				// ���� ��ü ����
				HttpSession session =request.getSession();
				
				// ���� �� ���� - ��ü�� ���� ��κ� ��?
				session.setAttribute("member", vo);
				
				
				
				response.sendRedirect("main.jsp");
				
				
				
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
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		


	
		
	}

}
