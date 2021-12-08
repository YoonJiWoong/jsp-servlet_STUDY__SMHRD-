package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex01") //이 친구는 지우면 안되!! : 제일 중요한 녀석이야!
public class ex01 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Server(Server + Applet(서버에서 작동하는 작은 프로그램)): Server(WAS : Tomcat)에서 
		//													Java 기반으로 작동하는 서버 프로그램
		//													Java:main() / Servlet:service()
		// ip 주소 : 59.0.147.241
		System.out.println("누군가 ex01 서버프로그램 호출");
		// request : Client의 모든 정보를 갖고 있는 객체(입력한 data)
		String ip = request.getRemoteAddr();
		System.out.println("접속한 사용자의 ip :" + ip);
		
		response.setContentType("text/html; charset=euc-kr");
		// response : Server가 Client에게 응답할 방식을 지정하는 객체 (생성, 이동)
		
		// 응답할 페이지와 인코딩 방식 지정
		// 한국어로 바꾸려면 charset=euc-kr
		
		PrintWriter out =response.getWriter();
		// 생성된 HTML 페이지와 현재 Servlet 파일을 연결
		out.write("응답페이지 생성성공 - 공격 하지 마시오!!");
		// PrintWriter 통로를 통해서 생성된 HTML에 값 입력
		
		
	}

}
