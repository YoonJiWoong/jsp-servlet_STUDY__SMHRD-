<%@page import="model.MemberVO"%>
<%@page import="model.MemberDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
	<%
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> al = dao.selectAll();
	//	System.out.println(al.size()); 잘 들어왔는지 확인하기 위해서 쓰는거!
	
	%>
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>전화번호</td>
								<td>주소</td>		
							</tr>
							<% for (int i=0; i<al.size(); i++){ %>		
							
							<tr>
							
							<td><%=al.get(i).getId()%></td>
							<td><%=al.get(i).getPw()%></td>
								
							<td><a href="DeleteService?email=
								<%=al.get(i).getId()%>">삭제</a></td>
							</tr>
							
							<% }%>
							
							<!-- get 방식 - 쿼리스트링 -->
							
						<!-- null값 삭제 : delete from web_member where email is null -->	
							
						<!-- 이렇게 쓰로 <  %  %  > 로 하고 out 쓸때는 주석처리 됨! -->
							
							<!--  
							
							
							for(MemberVO vo:al){
								out.print("<tr>");
								out.print("<td>"+vo.getEmail()+"</td>");
								out.print("<td>"+vo.getTel()+"</td>");
								out.print("<td>"+vo.getAddress()+"</td>");
								out.print("<td><a href='DeleteService?email="+vo.getEmail()+"'>삭제</a></td>");
								//"" 주의하기 -> '' 를 써야 안에서 인식함..아니면 ""랑 "" 로 인식됨
								out.print("</tr>");
							}
							
							
							
						-->
							
	
							
						</table>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

