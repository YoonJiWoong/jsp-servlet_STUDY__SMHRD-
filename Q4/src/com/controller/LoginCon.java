package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MovieDAO;
import com.model.MovieVO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	request.setCharacterEncoding("euc-kr");
		
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MovieVO vo = new MovieVO(id, pw);
		
		MovieDAO dao = new MovieDAO();
		
		String nick = dao.login_member(vo);
		
		System.out.println(nick);
		
		if(nick != null) {
			
			// ���� ��ü ����
			HttpSession session =request.getSession();
			
			// ���� �� ���� - ��ü�� ���� ��κ� ��?
			session.setAttribute("member", nick);
			
					
			response.sendRedirect("Question4_Main.jsp");
		}else {
			
			response.sendRedirect("Question4_Main.jsp");
			
		}
	
		
		
		
	}

}
