<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
body {
	background: #1c92d2; /* fallback for old browsers */
	min-height: 100vh;
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fffbd5;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}

#a {
	margin-bottom: 5.5rem;
	margin-top: 100px;
	
}
#btn btn-warning btn btn-primary btn-lg{

}

</style>




</head>

<%
	MemberDAO dao = new MemberDAO();
ArrayList<MemberVO> al = dao.selectAll();
%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<body style = "background-color : gray;">


	<div class="container">
	
		
			<div class="col-12" >



				<h2 align="center" id="a"  class="p-3 mb-2 bg-dark text-white">회원정보관리</h2>
				<table class="table table-secondary table-striped " border-spacing = "10px" >
					<thead>
						<tr>
							<th align = "center" scope="col" ></th>
							<th align = "center" scope="col" >ID</th>
							<th align = "center" scope="col" >PW</th>
							<th align = "center" scope="col"> 삭제</th>
						</tr>
					</thead>
					<tbody>
						<%for (int i = 0; i < al.size(); i++) {%>

						<tr>
							<th scope="row"><%=i + 1%></th>
							<td><%=al.get(i).getId()%></td>
							<td><%=al.get(i).getPw()%></td>
							<td><a align = "center" href="DeleteService?email=<%=al.get(i).getId()%>">삭제</a></td>
						</tr>
						<%}%>
						</table>
						
						
			<!-- 	<form action="Home.jsp" >
				<button  type="submit" class="btn btn-secondary btn btn-primary btn-lg" >홈으로</button>
				</form> -->
		<div class="logo" align="center" >
		<a href="index2.jsp"><img src="logo_120.png" alt=""></a>
		</div>
			</div>
	
	</div>

</body>
</html>