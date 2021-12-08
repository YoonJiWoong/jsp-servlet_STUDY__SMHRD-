package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BookDAO;
import com.model.BookDTO;


@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//������Ʈ �������� �Ű�����
		
				//��û������ ���ڵ� ��� ����( �ѱ� ���ڵ�)
				request.setCharacterEncoding("euc-kr");
				
				// ��û ������ �޾��ֱ�
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String nick = request.getParameter("nickname");
				String email = request.getParameter("email");
				String tel = request.getParameter("tel");
				
				BookDTO dto = new BookDTO(id, pw, nick, email, tel); 
				BookDAO dao = new BookDAO();
				
				int cnt = dao.insert_member(dto);			
				
				
				
				
				if(cnt>0) {
					System.out.println("���Լ���");
					
					// forward ������� ������ �̵�
					RequestDispatcher rd = request.getRequestDispatcher("Question4_Login.jsp");
					
					// ����ؾ��� ���� ����
					// request ������ ����ؾ��� ������ ����
					request.setAttribute("id",id); // ���� String ���� �����Ѱ� ����
					
					// ������ �̵��ҽ� request, response ��ü ����
					rd.forward(request, response); //�� ���� request,response ã�ƺ�!
					
					
					// response.sendRedirect("join_success.jsp?email="+email);
					// ������Ʈ�� ������� ������ ���� -> �������� getParameter();
					
				}else {
					System.out.println("���Խ���");
					response.sendRedirect("main.jsp");
					
					
				}
				
				
		
		
		
		
	}

}
