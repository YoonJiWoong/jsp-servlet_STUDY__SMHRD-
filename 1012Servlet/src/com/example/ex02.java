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
		// Client ���� �Է��� �����͸� �޾ƿ�����?

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("����ڰ� �Է��� ID�� :" + id);
		System.out.println("����ڰ� �Է��� PW�� :" + pw);
		
		// ����ڰ� �Է��� ID�� PW�� �������ִ� �������� ����ÿ�.
		response.setContentType("text/html; charset=euc-kr");
		
		PrintWriter out =response.getWriter();
		
		// out.write("����ڰ� �Է��� ID�� :" + id + "<br>" +"����ڰ� �Է��� PW�� :" + pw );
		out.print("����ڰ� �Է��� ID�� :" + id + "<br>" +"����ڰ� �Է��� PW�� :" + pw );
		// write ��� print �ᵵ ��!
		// <br>�±� �ٹٲ� : html ó�� �����ϱ�!
		
		
		// �� ���α׷����� �帧
		// 1. ����ڰ� ���� �Է��Ѵ�(HTML) action, name, submit
		// 2. ����ڰ� �Է��� ���� ������ �����´�(Servlet) request
		// 3. ����ڿ��� �����ϴ� �������� ������ش�.(Servlet -> HTML) response
		// + DB(JDBC)
		
		
		
	}

}
