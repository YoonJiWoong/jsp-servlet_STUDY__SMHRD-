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
		
		String a = (String)session.getAttribute("member");
		
		%>
		<%if(a.equals("admin")){ %>
		<button>��ȭ��ϰ���</button>
		<button>���Ű���</button>
		<button>ȸ������</button>
		
		<%}else if (a != null){ %>
			<button>���ͳν�</button>
		<button>��</button>
		<button>����2</button>
		
		
		<% }%>
		



</body>
</html>