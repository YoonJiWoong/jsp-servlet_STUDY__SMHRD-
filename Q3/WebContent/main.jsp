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
	<%String nickname = (String)session.getAttribute("nickname"); %>
		<td><%=nickname %>�� ȯ���մϴ�. <a href="loginForm.html">�α׾ƿ�</a>		</td>
		
		
	</tr>
	
	</table>
	
	<button>�����Է�</button>
	<button>����Ȯ��</button>
	</form>




</body>
</html>