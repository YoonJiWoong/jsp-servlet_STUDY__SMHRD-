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

		// ������ �־����!!!
		// int num3 = Integer.parseInt("num1"); �̷��� ���� num1�� �ٲٴ°�
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);

		// �Ʒ��� ������� ���� �������� ����Ͻÿ�
		System.out.println(num3 + num4);

		response.setContentType("text/html; charset=euc-kr"); //������� text html ����??

		PrintWriter out = response.getWriter();

		// out.write("����ڰ� �Է��� ID�� :" + id + "<br>" +"����ڰ� �Է��� PW�� :" + pw );
		out.print("�հ�" + (num3 + num4)); // ��Ʈ���� �Ǵϱ� num3+num4�� �����ľ�!!

	}

}
