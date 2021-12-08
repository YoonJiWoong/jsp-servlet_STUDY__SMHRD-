package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03_1")
public class ex03_1 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String select = request.getParameter("select"); // 대소문자 주의!!

		// 변수를 넣어줘야!!!
		// int num3 = Integer.parseInt("num1"); 이러면 문자 num1을 바꾸는거
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);

		// 아래의 결과값을 응답 페이지로 출력하시오

		response.setContentType("text/html; charset=euc-kr");

		PrintWriter out = response.getWriter();

		if (select.equals("+")) {
			out.print("합계" + (num3 + num4));
		} else if (select.equals("-")) {
			out.print("빼기" + (num3 - num4));
		} else if (select.equals("*")) {
			out.print("곱" + (num3 * num4));
		} else if (select.equals("/")) {
			out.print("나누기" + (num3 / num4));
		}

	}

}
