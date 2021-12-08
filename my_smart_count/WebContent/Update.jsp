<%@page import="model.MemberVO"%>
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
	
	MemberVO vo = (MemberVO)session.getAttribute("member"); 
	
	
	
	
	
	%>
	
		<h1>회원정보 수정!</h1>
	
	<form action="Update" method="post">
		<p>수정할 내용</p>
		PW<input type="password" name="pw"><br>
		닉네임<input value="<%=vo.getNick() %>" type="text" name="nick"><br>
		키<input value="<%=vo.getHeight() %>" type="text" name="height"><br>
		몸무게<input value="<%=vo.getKg() %>" type="text" name="kg"><br>
		나이<input value="<%=vo.getAge() %>" type="text" name="age" ><br>
		BMI<input value="<%=vo.getBMI() %>" type="text" name="bmi" ><br>
		남자<input type="radio" name="gender" value="M" required="required">
     	여자<input type="radio" name="gender" value="W" required="required">
		<input type="submit" value="수정">

	








</body>
</html>