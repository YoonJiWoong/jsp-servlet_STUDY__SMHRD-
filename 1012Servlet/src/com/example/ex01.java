package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex01") //�� ģ���� ����� �ȵ�!! : ���� �߿��� �༮�̾�!
public class ex01 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Server(Server + Applet(�������� �۵��ϴ� ���� ���α׷�)): Server(WAS : Tomcat)���� 
		//													Java ������� �۵��ϴ� ���� ���α׷�
		//													Java:main() / Servlet:service()
		// ip �ּ� : 59.0.147.241
		System.out.println("������ ex01 �������α׷� ȣ��");
		// request : Client�� ��� ������ ���� �ִ� ��ü(�Է��� data)
		String ip = request.getRemoteAddr();
		System.out.println("������ ������� ip :" + ip);
		
		response.setContentType("text/html; charset=euc-kr");
		// response : Server�� Client���� ������ ����� �����ϴ� ��ü (����, �̵�)
		
		// ������ �������� ���ڵ� ��� ����
		// �ѱ���� �ٲٷ��� charset=euc-kr
		
		PrintWriter out =response.getWriter();
		// ������ HTML �������� ���� Servlet ������ ����
		out.write("���������� �������� - ���� ���� ���ÿ�!!");
		// PrintWriter ��θ� ���ؼ� ������ HTML�� �� �Է�
		
		
	}

}
