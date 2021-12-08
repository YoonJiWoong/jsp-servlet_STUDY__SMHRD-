package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05")
// Web URL mapping : ���� �ּҰ��� �������� ���̱� ���ؼ� / ���Ȼ� �ּҰ��� ����� ���ؼ�

public class ex05 extends HttpServlet {
	
	
	/*
	  1. HTML
	  
	  2.
	  
	  3. 
	  
	  4. doGet, doPost�� �޼ҵ�� ��ǰ���
	  =get ��İ� post�� ó�����ִ� �޼ҵ� / �ϳ��� Servlet
	 
	 */
	
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("euc-kr");
		
		String job = request.getParameter("job");
		String gender =request.getParameter("gender");
		String [] hobby =request.getParameterValues("hobby");
		// üũ�ڽ��� 1���� �ƴ϶� �������� �Ѿ�� ���� ������ �迭�� ���!!
		
		String res_hobey = "";
		for(int i =0; i< hobby.length; i++) {
			res_hobey += hobby[i] + ",";
		}
		
		System.out.println("job : " +job);
		System.out.println("gender : " +gender);
		System.out.println("hobby : " +res_hobey);
		
		
		
	}

}
