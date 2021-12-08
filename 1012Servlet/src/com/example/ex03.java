package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex03")
public class ex03 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");

		// 변수를 넣어줘야!!!
		// int num3 = Integer.parseInt("num1"); 이러면 문자 num1을 바꾸는거
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);

		// 아래의 결과값을 응답 페이지로 출력하시오
		System.out.println(num3 + num4);

		response.setContentType("text/html; charset=euc-kr"); //응답받을 text html 생성??

		PrintWriter out = response.getWriter();

		// out.write("사용자가 입력한 ID값 :" + id + "<br>" +"사용자가 입력한 PW값 :" + pw );
		out.print("합계" + (num3 + num4)); // 스트링이 되니깐 num3+num4는 가로쳐야!!

	}

}
