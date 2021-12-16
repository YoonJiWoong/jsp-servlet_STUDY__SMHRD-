package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;

@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String email = request.getParameter("email");
		
		// ȸ�� ���� ��� ȣ��
		// ���� �Ϸ� -> ���� �Ϸ�! �ܼ�â�� ���
		// �����̿Ϸ� -> ��������! �ܼ�â�� ���
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.delete(email);
		
		if(cnt > 0) {
			
			System.out.println("��������");
			
			response.sendRedirect("selectMember.jsp");
			
			
		}else {
			
			System.out.println("��������");
			
			response.sendRedirect("selectMember.jsp");
			
		}
		
		
		
		
		
	}

}
