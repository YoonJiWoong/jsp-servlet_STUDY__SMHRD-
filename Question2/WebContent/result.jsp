<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>��ȣ�� ���� ���</h1>
	<table border="1" align="center">
	<tr>
		<th>�̸�</th>
		<th>�ں���</th>
	</tr>
	<tr>
		<td>�����ϴ°���</td>
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