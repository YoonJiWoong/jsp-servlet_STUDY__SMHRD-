<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.io.PrintWriter"%>
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
		// 내장객체 : 서버페이지를 개발할 때 많이 사용되는 객체를 미리 선언
		// 		   JSP -> WAS(Tomcat) -> Servlet*
		
//		request.getParameter("");
//		request.setCharacterEncoding("");
		
//		response.setContentType("");
//		PrintWriter out = response.getWriter();

		// out내장객체 : 스크랩틀릿 영역 안에서 웹 브라우저로 출력
		out.print("Hellow~");
		

	%>
	<br>
	Hellow~	
	<br>
		<table border="1">
		 	<tr>
		 		<%--td태그를 10번 반복하시오(스크립틀릿) --%>
		 		<%for(int i=0; i<=10; i++){%>
		 				<td>1</td>
		 		<%}%>

		 	</tr>
		 	<tr>
		 		<%--td태그를 10번 반복하시오(out 내장객체) --%>
		 		<%
		 		for(int i=0; i<=10; i++){
		 				out.print("<td>1</td>");
		 		}
		 		%>

		 	</tr>
		 	
		 	
		 </table>
		 
		 
		 <%
		GregorianCalendar gre = new GregorianCalendar(Locale.KOREA);
		 
		 int year = gre.get(gre.YEAR);
		 int month = gre.get(gre.MONTH);
		 int date = gre.get(gre.DATE);
		 int hour = gre.get(gre.HOUR);
		 int minute = gre.get(gre.MINUTE);
		 int second = gre.get(gre.SECOND);
		 
		 out.print(year+"년"+month+"월"+date+"일"+"<br>"+hour+"시"+minute+"분"+second+"초"+"<br>");
		 
		 
		 %>
		<%-- 표현식을 사용한 출력 --%>
		
		<%=year %> 년 <%=month+1 %>월 <%=date %>일 <br>
		<%=hour %> 시 <%=minute %>분<%=second %>초
	
	
	

</body>
</html>