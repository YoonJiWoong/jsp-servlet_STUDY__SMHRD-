package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex06")
public class ex06 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr"); // ���� ����!! �ڵ尡 ������ �Ʒ��� �����ϱ�
		
		String id = request.getParameter("id");
		String pw =request.getParameter("pw");
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		String tel = request.getParameter("tel");
		String gender =request.getParameter("gender");
		String [] hobby =request.getParameterValues("hobby");
		String birth =request.getParameter("birth");
		String color = request.getParameter("color");
		String country =request.getParameter("country");
		String talk =request.getParameter("talk");
		
		String res_hobey = "";
		for(int i =0; i< hobby.length; i++) {
			res_hobey += hobby[i]+" ";
		}
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		out.println("id : " +id+"<br>");
		out.println("pw : " +pw+"<br>");
		out.println("name : " +name+"<br>");
		out.println("email : " +email+"<br>");
		out.println("tel : " +tel+"<br>");
		out.println("hobby : " +res_hobey+"<br>");
		out.println("birth : " +birth+"<br>");
		out.println("color : " +color+"<br>");
		out.println("country : " +country+"<br>");
		out.println("talk : " +talk+"<br>");
		
		
		
		
		System.out.println("id : " +id);
		System.out.println("pw : " +pw);
		System.out.println("name : " +name);
		System.out.println("email : " +email);
		System.out.println("tel : " +tel);
		System.out.println("hobby : " +res_hobey);
		System.out.println("birth : " +birth);
		System.out.println("color : " +color);
		System.out.println("country : " +country);
		System.out.println("talk : " +talk);
		
		// ���� �帲
		// 1. html���� ����ڰ� ���� �Է��Ѵ�.
		
		// 2. Servlet���� ����ڰ� �Է� ���� �����´�. requset
		
		// 3. Servlet���� ����ڿ��� ������������ ����� �������ش�. respones
		
			
		
				
	}

}
