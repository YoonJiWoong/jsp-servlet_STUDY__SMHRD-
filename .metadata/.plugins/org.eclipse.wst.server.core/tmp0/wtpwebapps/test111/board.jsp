<%@page import="test111.BVO"%>
<%@page import="test111.BDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test111.MDAO"%>
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

BDAO dao = new BDAO();
ArrayList<BVO> al = dao.noContents();
int cnt = 1;




%>


<div class="tm-row">
                <div class="tm-col-left"></div>
                <main class="tm-col-right">
                    <section class="tm-content">
                        		<h1 style="text-align:center"><i>massage board</i></h1>
                        		<hr class="mb-5">
                               <table border="1">
                               	<tr>
                               		<th width="50" height="50" style="text-align:center">��ȣ</th>
                               		<th width="350" height="50" style="text-align:center">����</th>
                               		<th width="130" height="50" style="text-align:center">��¥</th>
                               		<th width="130" height="50" style="text-align:center">ȸ�����̵�</th>
                               	</tr>
                               	<%for(BVO svo : al){ %>
                               	<form action="ServiceCenterDetail.jsp" method="post">
                               	<tr>
                               	<input type="hidden" name="board_num" value="<%=svo.getBoard_num() %>">
                               		<td  width="50" height="50" style="text-align:center"><%=cnt++ %></td>
                               		<td  width="350" height="50" style="text-align:center"><button id=titleboard type="submit"><%=svo.getBoard_title() %></button></td>
                               		<td  width="130" height="50" style="text-align:center"><%=svo.getBoard_date() %></td>
                               		<td  width="130" height="50" style="text-align:center"><%=svo.getM_id() %></td>
                               		
                               	</tr>
                               	</form>
                               	<%} %>
                               </table>
                               <BR>
                               
                              <button><a href="Write.jsp" class="btn btn-primary">�۾���</a></button>
                            
                    </section>
                </main>
            </div>




</body>
</html>