
<%@page import="test111.MDTO"%>
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
MDTO mdto =(MDTO)session.getAttribute("member");
%>


       <%if(mdto == null){ %>
	   <form action="LoginCon">
	   ID <input type="text" name="id"><br>
       PW <input type="password" name="pw"><br>
       <input type="submit" value="�α���">
       <br>
       <a href="join.jsp">ȸ������</a>
       <!-- <button onclick="location.href=''">ȸ������</button>  -->
       
       </form>
       <% }else {%>
       
       
       <% 			session.setAttribute("member", mdto); 
       response.sendRedirect("board.jsp");
       %>
       
       <p>�α��� ������!!</p>
       <%} %>
       
       
</body>

</html>