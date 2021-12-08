<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%  Cookie cookie = new Cookie("testcookie","firstcookie");
	
	// 2. 유효기간 설정 (초단위)
	cookie.setMaxAge(60*60); // 1시간이라면!! 하루라면 24*60*60 이런식 1년이라면 365*24*60*60
	
	// 3. 클라이언트에게 쿠키 전송(응답 - response)
	response.addCookie(cookie);
	
	// 4. 쿠기 생성한 후 바로 클라이언트에 전송
	response.addCookie(new Cookie("id","test"));
	
%>

<a href="1.jsp">쿠키확인</a>
	
	
	
	

		
	
</body>
</html>