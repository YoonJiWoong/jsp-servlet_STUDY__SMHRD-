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
		HTML ������ Java�ڵ带 �ۼ�
		 �����ϴ� �������� �� �� ���� ������ ����--
		 
		 Servelet = JSP : �Ȱ��� ������� ����
		 
		 JSP ���� ���� :
		 ù��°   :  JSP -> WAS(Tomcat) -> Servlet -> class -> �޸����� -> ���������� ��ȯ
		 �ι�° ~: JSP -> WAS(Tomcat) -> �޸������ class -> ���������� ��ȯ 
		 
		 --%>
		 
		 <% //��ũ��Ʋ��(Scriptlet) : JSP�ȿ��� Java�ڵ带 ���� �� �� �ִ� ����
		 	int num1 = 10;
		 	int num2 = 5;
		 	int result = num1+num2;
		 	
		 	
		 %>
		 
		 num1��num2�� �� : <b><%=result %></b>
		<%-- ǥ����(expression) : JSP������ ������ ����� �� �ִ� ���� --%>
		 
		 <%-- 1~100������ ���� ����غ�����. --%>
		 <%
		 int sum=0;
		 for(int i=1; i<=100; i++){
			 sum +=i;
		 }
		 %>
		 <br>
		 1���� 100������ �� <b><%=sum %></b>
		 
		 <table border="1">
		 	<tr>
		 		<%--td�±׸� 10�� �ݺ��Ͻÿ� --%>
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