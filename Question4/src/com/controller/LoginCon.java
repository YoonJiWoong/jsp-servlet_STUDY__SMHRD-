package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BookDAO;
import com.model.BookDTO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		
		BookDAO dao = new BookDAO();
		BookDTO dto = new BookDTO(id, pw);
		
		String nick = dao.login_member(dto);
		
		
		
		if(nick != null) {
			
			// 技记 按眉 积己
			HttpSession session =request.getSession();
			
			// 技记 蔼 汲沥 - 按眉带 构电 措何盒 甸绢啊?
			session.setAttribute("member", nick);
			
					
			response.sendRedirect("Question4_Main.jsp");
		}else {
			
			
			
		}
	
	
	}

}
