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
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		if(id.equals("test")&&pw.equals("12345")){
			session.setAttribute("nick", "�г���������"); //���ǻ���
			response.sendRedirect("main.jsp"); // main.jsp
		}else{
			response.sendRedirect("loginform.html");
			
		}
	
	%>
</body>
</html>