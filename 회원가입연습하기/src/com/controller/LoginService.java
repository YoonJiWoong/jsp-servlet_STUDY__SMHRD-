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
		
		
		
		
		Connection conn =null;
		PreparedStatement psmt = null;
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
			
			psmt = conn.prepareStatement(sql);
			
			// 4. ���ε� ���� ä���α�
			psmt.setString(1, email);
			psmt.setString(2, pw);
			
			// 5. sql�� ���� �� ��� ó��
			rs = psmt.executeQuery();
			// ������ ��� Ŀ�� �޾ƿ���
			
			boolean check = rs.next();
			
			// rs.next() -> true / false
			if(check==true) {
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
				response.sendRedirect("main.jsp");
			}
			//System.out.println("�α��� ���� ���� :"+check);
			
			
			

			
		} catch (Exception e) {
			System.out.println("�α��ν���");
			response.sendRedirect("main.jsp");
			e.printStackTrace();
		} finally {
			
			// 1. ��������
			// 2. ����ó��
			
			try {
				if(rs!=null) {
					rs.close();
					
				}
				
				if(psmt!=null) {
					psmt.close();
					
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
