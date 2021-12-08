<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<style>
	tr{
		height: 40px;
		text-align: center;
	}
	table{
		margin: 0 auto;
	}
</style>

<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	
	String name = request.getParameter("name");
	int java =Integer.parseInt(request.getParameter("java")); // 1줄로 만드는 방법
	String web =request.getParameter("web");
	String iot =request.getParameter("iot");
	String android =request.getParameter("android");
	
	
	int num2 = Integer.parseInt(web);
	int num3 = Integer.parseInt(iot);
	int num4 = Integer.parseInt(android);
	int avg = (java+num2+num3+num4)/4;
	String grade;
	if(avg>=95){
		grade="A+";
	}else if(avg>=85){
		grade="A";
	}else if(avg>=80){
		grade="B+";
	}else if(avg>=70){
		grade="C";
	}else{
		grade="F";
	}
	
	
	
	
	%>
	
			<fieldset>
			<legend>성적확인프로그램</legend>
			<table width="500">	
				<tr>
					<td>이름</td>
					<td><%=name %></td>
				</tr>
				<tr>
					<td>JAVA점수</td>
					<td><%=java %></td>
				</tr>
				<tr>
					<td>WEB점수</td>
					<td><%=web %></td>
				</tr>
					<tr>
					<td>IOT점수</td>
					<td><%=iot %></td>
				</tr>		
				<tr>
					<td>ANDROID점수</td>
					<td><%=android %></td>
				</tr>
				<tr>
					<td>평균</td>
					<td><%=(java+num2+num3+num4)/4 %></td>
					<%-- 이것도 가능 <%=avg%> --%>
				</tr>
				
				<tr>
					<td>학점</td>
			<%-- 방법2 		
			<td>
					<%
						if(avg>=95){
							out.print("A+");
						}else if(avg>=85){
							out.print("B");
						}
					
					
					%>
					
					</td>  
					  --%>
					<th ><%=grade %></th>
				</tr>
						
																																		
			</table>
		</fieldset>
	
	
</body>
</html>