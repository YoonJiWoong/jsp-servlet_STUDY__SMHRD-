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
	// 1. ������ ��Ű�� ������ name ���� ���� ��Ű ��ü ���� (value�� �������)
	Cookie cookie = new Cookie("testcookie", ""); // ���� �̸��� �����ϰ� �Ȱ���, �ڿ��� �������.
	
	// 2. ��ȿ�Ⱓ�� 0���� ����
	cookie.setMaxAge(0);
	
	// 3. ��Ű�� Ŭ���̾�Ʈ���� ����(����)
	response.addCookie(cookie);
	

	%>
	<a href="Ex02GetCookie.jsp">��ŰȮ��</a>	

</body>
</html>