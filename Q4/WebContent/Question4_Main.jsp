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
		<button>영화목록관리</button>
		<button>예매관리</button>
		<button>회원관리</button>
		
		<%}else if (a != null){ %>
			<button>이터널스</button>
		<button>듄</button>
		<button>베놈2</button>
		
		
		<% }%>
		



</body>
</html>