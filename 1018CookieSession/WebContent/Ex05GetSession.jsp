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
		// �ٿ�ĳ����
		
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	Integer age = (Integer)session.getAttribute("age");
	
	%>
	
	
	���̵� : <%=id %><br>
	��й�ȣ : <%=pw %><br>
	���� : <%=age %>
	<br>
	<a href="Ex06RemoveSession.jsp">���ǻ���</a>
	<a href="Ex07InvalidateSession.jsp">���Ǹ�λ���</a>

</body>
</html>