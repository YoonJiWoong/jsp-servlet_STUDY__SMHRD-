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
		String select = request.getParameter("select"); // ��ҹ��� ����!!

		// ������ �־����!!!
		// int num3 = Integer.parseInt("num1"); �̷��� ���� num1�� �ٲٴ°�
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);

		// �Ʒ��� ������� ���� �������� ����Ͻÿ�

		response.setContentType("text/html; charset=euc-kr");

		PrintWriter out = response.getWriter();

		if (select.equals("+")) {
			out.print("�հ�" + (num3 + num4));
		} else if (select.equals("-")) {
			out.print("����" + (num3 - num4));
		} else if (select.equals("*")) {
			out.print("��" + (num3 * num4));
		} else if (select.equals("/")) {
			out.print("������" + (num3 / num4));
		}

	}

}
