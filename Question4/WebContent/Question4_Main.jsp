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
		<button>회원관리</button>
		<button>도서관리</button>
		<button>대여관리</button>
		<button>재고관리</button>
		<%}else if (a != null){ %>
			<button>회원관리</button>
		<button>도서검색</button>
		<button>나의책방</button>
		<button>즐겨찾기</button>
		<button>회원정보</button>
		
		<% }%>
		
</body>
</html>