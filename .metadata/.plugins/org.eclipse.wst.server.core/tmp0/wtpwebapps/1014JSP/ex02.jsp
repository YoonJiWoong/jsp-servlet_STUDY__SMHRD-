<%@page import="com.example.ex01Plus"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! // 선언문 : JSP 내에서  메소드나 상수를 선언할 때 사용하는 영역
	

	%>
	
	<%
	 ex01Plus ex01 = new ex01Plus();
	 int result = ex01.sum(5, 10);
	%>
	ex01Plus 파일의 sum 메소드 호출 : <%=result %>
	
	
</body>
</html>