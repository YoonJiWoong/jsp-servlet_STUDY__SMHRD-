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
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.login(email, pw);
		
		if(vo != null) {
			
			// ���� ��ü ����
			HttpSession session =request.getSession();
			
			// ���� �� ���� - ��ü�� ���� ��κ� ��?
			session.setAttribute("member", vo);
			
			
			
			response.sendRedirect("main.jsp");
		}else {
			
			response.sendRedirect("main.jsp");
			
		}
		
		

		
		

	
		
	}

}
