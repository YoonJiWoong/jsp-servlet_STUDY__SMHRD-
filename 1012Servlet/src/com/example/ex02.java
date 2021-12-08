package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Client 에게 입력한 데이터를 받아오려면?

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("사용자가 입력한 ID값 :" + id);
		System.out.println("사용자가 입력한 PW값 :" + pw);
		
		// 사용자가 입력한 ID와 PW를 응답해주는 페이지를 만드시오.
		response.setContentType("text/html; charset=euc-kr");
		
		PrintWriter out =response.getWriter();
		
		// out.write("사용자가 입력한 ID값 :" + id + "<br>" +"사용자가 입력한 PW값 :" + pw );
		out.print("사용자가 입력한 ID값 :" + id + "<br>" +"사용자가 입력한 PW값 :" + pw );
		// write 대신 print 써도 되!
		// <br>태그 줄바꿈 : html 처럼 생각하기!
		
		
		// 웹 프로그래밍의 흐름
		// 1. 사용자가 값을 입력한다(HTML) action, name, submit
		// 2. 사용자가 입력한 값을 변수로 가져온다(Servlet) request
		// 3. 사용자에게 응답하는 페이지를 만들어준다.(Servlet -> HTML) response
		// + DB(JDBC)
		
		
		
	}

}
