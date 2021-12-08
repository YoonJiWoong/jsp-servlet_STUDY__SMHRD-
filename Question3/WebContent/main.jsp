<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<form align="center" action="loginForm.html">
	<h1>빅데이터 과정 회원 시스템</h1>
	<table border="1" align="center">
	<tr>
	<%String id = (String)session.getAttribute("id"); %>
		<td><%=id %>님 환영합니다.</td>
		
	</tr>
	
	<tr>
		
		<td colspan="2" align="center"><input type="submit" value="로그아웃"></td>
	</tr>
	</table>
	</form>


</body>
</html>