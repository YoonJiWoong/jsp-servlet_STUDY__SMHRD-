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
	<h1>빅데이터 과정 회원 시스템</h1>
	<table border="1" align="center">
	<tr>
	<%String nickname = (String)session.getAttribute("nickname"); %>
		<td><%=nickname %>님 환영합니다. <a href="loginForm.html">로그아웃</a>		</td>
		
		
	</tr>
	
	</table>
	
	<button>성적입력</button>
	<button>성적확인</button>
	</form>




</body>
</html>