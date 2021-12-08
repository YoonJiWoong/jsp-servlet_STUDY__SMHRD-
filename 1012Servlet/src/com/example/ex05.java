package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05")
// Web URL mapping : 파일 주소값을 가독성을 높이기 위해서 / 보안상 주소값을 숨기기 위해서

public class ex05 extends HttpServlet {
	
	
	/*
	  1. HTML
	  
	  2.
	  
	  3. 
	  
	  4. doGet, doPost는 메소드는 어떤건가요
	  =get 방식과 post을 처리해주는 메소드 / 하나의 Servlet
	 
	 */
	
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("euc-kr");
		
		String job = request.getParameter("job");
		String gender =request.getParameter("gender");
		String [] hobby =request.getParameterValues("hobby");
		// 체크박스는 1개가 아니라 여러개가 넘어올 수도 있으니 배열을 써야!!
		
		String res_hobey = "";
		for(int i =0; i< hobby.length; i++) {
			res_hobey += hobby[i] + ",";
		}
		
		System.out.println("job : " +job);
		System.out.println("gender : " +gender);
		System.out.println("hobby : " +res_hobey);
		
		
		
	}

}
