<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Insert title here</title>
<% 
	//request.setCharacterEncoding("UTF-8");  //�ѱ۱����� �ּ�����
	request.setCharacterEncoding("EUC-KR");  //�ش�ý����� ���ڵ�Ÿ���� EUC-KR�ϰ�쿡
	String inputYn = request.getParameter("inputYn"); 
	String roadFullAddr = request.getParameter("roadFullAddr"); 
	String admCd    = request.getParameter("admCd");
	
	
	//db ������ admCd �� ������Ʈ���ٰ�
	
	
%>
</head>
<script language="javascript">
// opener���� ������ �߻��ϴ� ��� �Ʒ� �ּ��� �����ϰ�, ������� ������������ �Է��մϴ�. ("�ּ��Է�ȭ�� �ҽ�"�� �����ϰ� ������Ѿ� �մϴ�.)
//document.domain = "abc.go.kr";

/*
		���� ��ŷ �׽�Ʈ �� �˾�API�� ȣ���Ͻø� IP�� ���� �� �� �ֽ��ϴ�. 
		�ּ��˾�API�� �����Ͻð� �׽�Ʈ �Ͻñ� �ٶ��ϴ�.
*/

function init(){
	var url = location.href;
	var confmKey = "devU01TX0FVVEgyMDIxMTAyMzE0MjEzMTExMTc5MTE=";
	var resultType = "4"; // ���θ��ּ� �˻���� ȭ�� ��³���, 1 : ���θ�, 2 : ���θ�+����+�󼼺���(��������, �����ֹμ���), 3 : ���θ�+�󼼺���(�󼼰ǹ���), 4 : ���θ�+����+�󼼺���(��������, �����ֹμ���, �󼼰ǹ���)
	var inputYn= "<%=inputYn%>";
	if(inputYn != "Y"){
		document.form.confmKey.value = confmKey;
		document.form.returnUrl.value = url;
		document.form.resultType.value = resultType;
		document.form.action="https://www.juso.go.kr/addrlink/addrLinkUrl.do"; //���ͳݸ�
		//document.form.action="https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do"; //����� ���� ���, ���ͳݸ�
		document.form.submit();
		
	}else{
		opener.jusoCallBack("<%=roadFullAddr%>", "<%=admCd%>");
		window.close();
		}
}

</script>
<body onload="init();">
	<form id="form" name="form" method="post">
		<input type="hidden" id="confmKey" name="confmKey" value=""/>
		<input type="hidden" id="returnUrl" name="returnUrl" value=""/>
		<input type="hidden" id="resultType" name="resultType" value=""/>
		<!-- �ش�ý����� ���ڵ�Ÿ���� EUC-KR�ϰ�쿡�� �߰� START-->
		
		<input type="hidden" id="encodingType" name="encodingType" value="EUC-KR"/>
		
		<!-- �ش�ý����� ���ڵ�Ÿ���� EUC-KR�ϰ�쿡�� �߰� END-->
	</form>
</body>
</html>