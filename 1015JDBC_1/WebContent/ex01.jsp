<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%-- 지시자 : JSP를 실행했을 때 전체적인 환경 설정 --%>
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
		// 외부 페이지 이동 
		
		response.sendRedirect("ex02.jsp");
		// 내부 페이지 이동
		// 같은 프로젝트 내에서만 가능
		
		// 로그인 시스템
		// 1. 로그인 할 수 있는 HTML페이지
		// 2. 아이디와 패스워드가 맞는지 체크하는 JSP
		// 3. 성공했을 때 JSP
		// 4. 실패했 을때 JSP
		
	
	%>
	
	
</body>
</html>