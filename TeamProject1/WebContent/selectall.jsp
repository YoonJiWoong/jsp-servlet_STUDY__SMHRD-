<%@page import="java.util.ArrayList"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
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
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> al = dao.selectAll();
	
	%>


	<table>
							<caption><h2>ȸ������������</h2></caption>
							<tr>
								<td>Email</td>
								<td>��ȭ��ȣ</td>
								<td>�ּ�</td>		
							</tr>
							<% for (int i=0; i<al.size(); i++){ %>		
							
							<tr>
							
							<td><%=al.get(i).getId() %></td>
							<td><%=al.get(i).getNick() %></td>
							
							<td><a href="Delete?id=<%=al.get(i).getId()%>">����</a></td>
							</tr>
							
							<% }%>
</table>


</body>
</html>