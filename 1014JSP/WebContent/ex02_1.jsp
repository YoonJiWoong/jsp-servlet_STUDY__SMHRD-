<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
	<%-- tr,td �ٹٲ� �Ҷ��� tr td�� --%>		

			<%
			int a = 0;
			for (int i = 1; i <= 9; i++) {
			%>
			<tr>
			<%
				for (int j = 1; j <= 9; j++) {
				a = i * j;
			%>

			<td><%=i + "*" + j + "=" + a%></td>
			
			<%
				}
			
			%>
				</tr>
			<%
				}
			%>
			

		

	</table>






</body>
</html>