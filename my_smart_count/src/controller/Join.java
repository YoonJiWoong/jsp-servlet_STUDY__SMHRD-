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
		String nick = request.getParameter("nick");
		String height = request.getParameter("height");
		String kg = request.getParameter("kg");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String bmi = request.getParameter("bmi");
		
		
	
		
	
		MemberDAO dao= new MemberDAO();
		
		int cnt = dao.Join(id, pw, nick, height, kg, gender, age, bmi);
				
		if(cnt > 0) {
			System.out.println("회원가입성공");
			response.sendRedirect("index2.jsp");
		}else {
			System.out.println("회원가입실패");
			response.sendRedirect("index2.jsp");
		}
		
	} 
		
		
	}

		
		
		
	


