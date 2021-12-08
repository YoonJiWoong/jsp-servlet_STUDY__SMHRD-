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
		// session 내장 객체 사용
		// 1. 세션 값 설정 setAttribute(NAME(String), VALUE(Object))
		
		// 업캐스닝!! 문자열을 오브젝트
		
		session.setAttribute("id", "test");
		session.setAttribute("pw", "12345");
		session.setAttribute("age", 25);
		
	%>
	
	<a href="Ex05GetSession.jsp">세션확인</a>
	

</body>
</html>