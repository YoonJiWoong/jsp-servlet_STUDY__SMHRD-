<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%-- ������ : JSP�� �������� �� ��ü���� ȯ�� ���� --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// response.setContentType("text/html; charset=euc-kr");
		// PrintWriter out1 = response.getWriter();
		
		//response.sendRedirect("http://www.naver.com");
		// �ܺ� ������ �̵� 
		
		response.sendRedirect("ex02.jsp");
		// ���� ������ �̵�
		// ���� ������Ʈ �������� ����
		
		// �α��� �ý���
		// 1. �α��� �� �� �ִ� HTML������
		// 2. ���̵�� �н����尡 �´��� üũ�ϴ� JSP
		// 3. �������� �� JSP
		// 4. ������ ���� JSP
		
	
	%>
	
	
</body>
</html>