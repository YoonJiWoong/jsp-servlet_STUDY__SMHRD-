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
	// session.invalidate(); ��ü����
	session.removeAttribute("nick");
	// response.sendRedirect("loginform.html");
	%>
	
	<script>
	alert("�α׾ƿ�!");
	location.href="loginform.html";
	</script>
	
</body>
</html>