<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		// session ���� ��ü ���
		// 1. ���� �� ���� setAttribute(NAME(String), VALUE(Object))
		
		// ��ĳ����!! ���ڿ��� ������Ʈ
		
		session.setAttribute("id", "test");
		session.setAttribute("pw", "12345");
		session.setAttribute("age", 25);
		
	%>
	
	<a href="Ex05GetSession.jsp">����Ȯ��</a>
	

</body>
</html>