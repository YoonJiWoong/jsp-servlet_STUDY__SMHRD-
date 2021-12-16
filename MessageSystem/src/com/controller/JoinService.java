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

import com.model.MemberDAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리퀘스트 리스폰스 매개인자
		
		//요청데이터 인코딩 방식 지정( 한글 인코딩)
		request.setCharacterEncoding("euc-kr");
		
		// 요청 데이터 받아주기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.join(email, pw, tel, address);
		
		
		
		
		
		if(cnt>0) {
			System.out.println("가입성공");
			
			// forward 방식으로 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			
			// 기억해야할 정보 세팅
			// request 영역에 기억해야할 데이터 설정
			request.setAttribute("email",email); // 위에 String 변수 설정한거 생각
			
			// 페이지 이동할시 request, response 객체 전달
			rd.forward(request, response); //맨 위에 request,response 찾아봐!
			
			
			// response.sendRedirect("join_success.jsp?email="+email);
			// 쿼리스트링 방식으로 데이터 전송 -> 받을때는 getParameter();
			
		}else {
			System.out.println("가입실패");
			response.sendRedirect("main.jsp");
			
			
		}
		
		
		
	}

}
