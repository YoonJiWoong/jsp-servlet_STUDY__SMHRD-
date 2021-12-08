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
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");
String select = request.getParameter("select"); 


int num3 = Integer.parseInt(num1);
int num4 = Integer.parseInt(num2);


if (select.equals("+")) {
	%><%=num1%><%=select%><%=num2%>=<%=num3+num4%><%
} else if (select.equals("-")) {
	%><%=num1%><%=select%><%=num2%>=<%=num3-num4%><%
} else if (select.equals("*")) {
	%><%=num1%><%=select%><%=num2%>=<%=num3*num4%><%
} else if (select.equals("/")) {
	%><%=num1%><%=select%><%=num2%>=<%=num3/num4%><%
}

%>




</body>
</html>