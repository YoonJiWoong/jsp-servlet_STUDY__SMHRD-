<%@page import="test111.MDTO"%>
<%@page import="test111.MDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="test111.BVO"%>
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
	MDTO vo = (MDTO)session.getAttribute("member");
	LocalDate now = LocalDate.now();

	%>
<form action="WriteServiceCenter" method="post">
	      <table border="1">
                                  <tr>
                                     <th width="200" height="50" style="text-align:center">제목</th>
                                     <th width="500" height="50" style="text-align:center"><input type="text" name="board_title"></th>
                                  </tr>
                                  
                                  <tr>
                                     <th width="200" height="50"style="text-align:center">회원아이디</th>
                                     <th width="500" height="50" style="text-align:center"  name="id"><%=vo.getId()%></th>
                                  </tr>   
                                 
                                  <tr>
                                     <th width="200" height="50"style="text-align:center">날짜</th>
                                     <th width="500" height="50" style="text-align:center" name="board_date"><%=now %></th>
                               </tr>
                                  <tr>
                                     <th colspan="2" width="200" height="50"style="text-align:center">내용</th>
                                     
                               </tr>
                                <tr>
                               <td colspan="2" width="500" height="50" style="text-align:center"><textarea cols="50" rows="5" name="board_contents"></textarea></td>
                               </tr>
                               </table>
                               <input type="submit"  value="글쓰기">
                               <>
	</form>
	

</body>
</html>