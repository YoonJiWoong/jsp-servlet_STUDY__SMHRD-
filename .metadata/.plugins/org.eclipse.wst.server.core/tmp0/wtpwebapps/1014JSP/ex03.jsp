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
		// ���尴ü : ������������ ������ �� ���� ���Ǵ� ��ü�� �̸� ����
		// 		   JSP -> WAS(Tomcat) -> Servlet*
		
//		request.getParameter("");
//		request.setCharacterEncoding("");
		
//		response.setContentType("");
//		PrintWriter out = response.getWriter();

		// out���尴ü : ��ũ��Ʋ�� ���� �ȿ��� �� �������� ���
		out.print("Hellow~");
		

	%>
	<br>
	Hellow~	
	<br>
		<table border="1">
		 	<tr>
		 		<%--td�±׸� 10�� �ݺ��Ͻÿ�(��ũ��Ʋ��) --%>
		 		<%for(int i=0; i<=10; i++){%>
		 				<td>1</td>
		 		<%}%>

		 	</tr>
		 	<tr>
		 		<%--td�±׸� 10�� �ݺ��Ͻÿ�(out ���尴ü) --%>
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
		 
		 out.print(year+"��"+month+"��"+date+"��"+"<br>"+hour+"��"+minute+"��"+second+"��"+"<br>");
		 
		 
		 %>
		<%-- ǥ������ ����� ��� --%>
		
		<%=year %> �� <%=month+1 %>�� <%=date %>�� <br>
		<%=hour %> �� <%=minute %>��<%=second %>��
	
	
	

</body>
</html>