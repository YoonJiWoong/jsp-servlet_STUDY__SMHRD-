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
			//2. OracleDriver.class �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3. Oracle�� ���� DBID, DBPW�� ����
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("���Ἲ��");
			}else {
				System.out.println("�������");
			}
			
			//4. SQL�� �غ�
			String sql = "insert into WEB_MEMBER  values(?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, tel);
			psmt.setString(4, address);
			
			int cnt = psmt.executeUpdate();
		
		
		
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
			e.printStackTrace();
		}
		
		
		
		
	}
}




		
	


