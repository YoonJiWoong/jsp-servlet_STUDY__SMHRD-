<%@page import="com.model.BookDTO"%>
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
		<button>ȸ������</button>
		<button>��������</button>
		<button>�뿩����</button>
		<button>������</button>
		<%}else if (a != null){ %>
			<button>ȸ������</button>
		<button>�����˻�</button>
		<button>����å��</button>
		<button>���ã��</button>
		<button>ȸ������</button>
		
		<% }%>
		
</body>
</html>