
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
       <input type="submit" value="로그인">
       <br>
       <a href="join.jsp">회원가입</a>
       <!-- <button onclick="location.href=''">회원가입</button>  -->
       
       </form>
       <% }else {%>
       
       
       <% 			session.setAttribute("member", mdto); 
       response.sendRedirect("board.jsp");
       %>
       
       <p>로그인 성공요!!</p>
       <%} %>
       
       
</body>

</html>