<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%  Cookie cookie = new Cookie("testcookie","firstcookie");
	
	// 2. ��ȿ�Ⱓ ���� (�ʴ���)
	cookie.setMaxAge(60*60); // 1�ð��̶��!! �Ϸ��� 24*60*60 �̷��� 1���̶�� 365*24*60*60
	
	// 3. Ŭ���̾�Ʈ���� ��Ű ����(���� - response)
	response.addCookie(cookie);
	
	// 4. ��� ������ �� �ٷ� Ŭ���̾�Ʈ�� ����
	response.addCookie(new Cookie("id","test"));
	
%>

<a href="1.jsp">��ŰȮ��</a>
	
	
	
	

		
	
</body>
</html>