<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>선호도 조사 결과</h1>
	<table border="1" align="center">
	<tr>
		<th>이름</th>
		<th>박병관</th>
	</tr>
	<tr>
		<td>좋아하는과일</td>
		<%
		request.setCharacterEncoding("euc-kr");

		String [] fruit = request.getParameterValues("fruit"); %>
		
		<td>
			<%for(int i=0; i<fruit.length;i++){
				
			 %><%=fruit[i] %><% 
				
			} %>
     		</td>
	</tr>
	
	</table>


</body>
</html>