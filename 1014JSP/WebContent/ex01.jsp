<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP(Java Server Page)
		HTML 내에서 Java코드를 작성
		 응답하는 페이지를 좀 더 쉽게 개발이 가능--
		 
		 Servelet = JSP : 똑같은 기능정의 가능
		 
		 JSP 실행 과정 :
		 첫번째   :  JSP -> WAS(Tomcat) -> Servlet -> class -> 메모리저장 -> 응답페이지 변환
		 두번째 ~: JSP -> WAS(Tomcat) -> 메모리저장된 class -> 응답페이지 변환 
		 
		 --%>
		 
		 <% //스크립틀릿(Scriptlet) : JSP안에서 Java코드를 구현 할 수 있는 영역
		 	int num1 = 10;
		 	int num2 = 5;
		 	int result = num1+num2;
		 	
		 	
		 %>
		 
		 num1과num2의 합 : <b><%=result %></b>
		<%-- 표현식(expression) : JSP내에서 변수를 출력할 수 있는 영역 --%>
		 
		 <%-- 1~100까지의 합을 출력해보세요. --%>
		 <%
		 int sum=0;
		 for(int i=1; i<=100; i++){
			 sum +=i;
		 }
		 %>
		 <br>
		 1부터 100까지의 합 <b><%=sum %></b>
		 
		 <table border="1">
		 	<tr>
		 		<%--td태그를 10번 반복하시오 --%>
		 		<%for(int i=0; i<=10; i++){%>
		 				
		 				<td>1<td>
		 				
		 			<%}%>
		 		
		 		
		 		
		 	
		 	
		 	</tr>
		 	
		 
		 
		 </table>
		 
		 
		 <%
		 	request.getParameter("");
		 	response.setContentType("");
		 %>
		 
		 
		 
	<script>
		//JavaScript
	</script>
	
	<style>
		/* CSS */
	</style>
		 
		 
</body>
</html>