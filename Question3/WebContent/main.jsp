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
	<h1>������ ���� ȸ�� �ý���</h1>
	<table border="1" align="center">
	<tr>
	<%String id = (String)session.getAttribute("id"); %>
		<td><%=id %>�� ȯ���մϴ�.</td>
		
	</tr>
	
	<tr>
		
		<td colspan="2" align="center"><input type="submit" value="�α׾ƿ�"></td>
	</tr>
	</table>
	</form>


</body>
</html>