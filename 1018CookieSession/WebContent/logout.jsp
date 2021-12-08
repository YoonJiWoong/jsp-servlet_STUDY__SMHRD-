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
	// session.invalidate(); 전체삭제
	session.removeAttribute("nick");
	// response.sendRedirect("loginform.html");
	%>
	
	<script>
	alert("로그아웃!");
	location.href="loginform.html";
	</script>
	
</body>
</html>