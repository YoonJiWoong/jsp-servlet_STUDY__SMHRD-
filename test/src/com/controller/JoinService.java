package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn= null;
		PreparedStatement pst = null;
		
		//������Ʈ �������� �Ű�����
		
		//��û������ ���ڵ� ��� ����( �ѱ� ���ڵ�)
		request.setCharacterEncoding("euc-kr");
		
		// ��û ������ �޾��ֱ�
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		//	System.out.println(eamil+","+pw+","+tel+","+address);
		
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
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				System.out.println("���Լ���");
				
				// forward ������� ������ �̵�
				RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
				
				// ����ؾ��� ���� ����
				// request ������ ����ؾ��� ������ ����
				request.setAttribute("email",email); // ���� String ���� �����Ѱ� ����
				
				// ������ �̵��ҽ� request, response ��ü ����
				rd.forward(request, response); //�� ���� request,response ã�ƺ�!
				
				
				// response.sendRedirect("join_success.jsp?email="+email);
				// ������Ʈ�� ������� ������ ���� -> �������� getParameter();
				
			}else {
				System.out.println("���Խ���");
				response.sendRedirect("main.jsp");
				
				
			}
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
		
		
		
		
		
		
		
	}

}
