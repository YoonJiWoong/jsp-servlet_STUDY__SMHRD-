package controller;

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

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo;
		
		
		
		vo = dao.login(id, pw);
		
	if(vo != null) {
			
			// ���� ��ü ����
			HttpSession session =request.getSession();
			
			// ���� �� ���� - ��ü�� ���� ��κ� ��?
			session.setAttribute("member", vo);
			
			
			
			response.sendRedirect("home.jsp");
		}else {
			
			response.sendRedirect("home.jsp");
			
		}
		
		
		
		
		}
	}

