package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;


@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String height = request.getParameter("height");
		String kg = request.getParameter("kg");
		
		MemberVO vo = new MemberVO(id, pw, height, kg, age, gender);
		MemberDAO dao= new MemberDAO();
		
		int cnt = dao.Join(id, nick, pw, age, gender, height, kg);
		
		if(cnt > 0) {
			System.out.println("회원가입성공");
			response.sendRedirect("home.jsp");
		}else {
			System.out.println("회원가입실패");
			response.sendRedirect("home.jsp");
		}
		
	} 
		
		
	}

		
		
		
	


