/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2021-11-22 06:16:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.model.MemberVO;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.model.MemberVO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<title>Forty by HTML5 UP</title>\r\n");
      out.write("		<meta charset=\"EUC-KR\" />\r\n");
      out.write("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("		<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("		\r\n");
      out.write("		");

		//현재 로그인 상태인지 판별 (vo == null -> 로그인 하지 않은 상태)	
		MemberVO vo = (MemberVO)session.getAttribute("member");
			
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<!-- Wrapper -->\r\n");
      out.write("			<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("				<!-- Header -->\r\n");
      out.write("					<header id=\"header\" class=\"alt\">\r\n");
      out.write("						<a href=\"index.html\" class=\"logo\"><strong>Forty</strong> <span>by HTML5 UP</span></a>\r\n");
      out.write("						<nav>\r\n");
      out.write("							");
if(vo==null){ 
      out.write("\r\n");
      out.write("							<a href=\"#menu\">로그인</a>\r\n");
      out.write("							");
}else{ 
      out.write("\r\n");
      out.write("							\r\n");
      out.write("							");
 if(vo.getEmail().equals("admin")){  
      out.write("\r\n");
      out.write("							<a href=\"selectMember.jsp\">전체회원정보</a>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("							\r\n");
      out.write("							\r\n");
      out.write("							<a href=\"update.jsp\">개인정보수정</a>\r\n");
      out.write("							<a href=\"LogoutService\">로그아웃</a>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("						</nav>\r\n");
      out.write("					</header>\r\n");
      out.write("\r\n");
      out.write("				<!-- Menu -->\r\n");
      out.write("					<nav id=\"menu\">	\r\n");
      out.write("						<ul class=\"links\">\r\n");
      out.write("							<li><h5>로그인</h5></li>\r\n");
      out.write("								<form action=\"LoginService\" method=\"post\">\r\n");
      out.write("									<li><input name=\"email\"  type=\"text\" placeholder=\"Email을 입력하세요\"></li>\r\n");
      out.write("									<li><input name=\"pw\" type=\"password\" placeholder=\"PW를 입력하세요\"></li>\r\n");
      out.write("									<li><input type=\"submit\" value=\"LogIn\" class=\"button fit\"></li>\r\n");
      out.write("								</form>\r\n");
      out.write("						</ul>\r\n");
      out.write("						<ul class=\"actions vertical\">\r\n");
      out.write("							<li><h5>회원가입</h5></li>\r\n");
      out.write("								<form action=\"JoinService\" method=\"post\">\r\n");
      out.write("									<li><input name=\"email\" id=\"input_id\" type=\"text\" placeholder=\"Email을 입력하세요\">\r\n");
      out.write("										<input type=\"button\" value=\"중복체크\" onclick=\"idCheck()\">\r\n");
      out.write("										<span id=\"sp_result\"></span>		\r\n");
      out.write("									</li>\r\n");
      out.write("									<li><input name=\"pw\" type=\"password\" placeholder=\"PW를 입력하세요\"></li>\r\n");
      out.write("									<li><input name=\"tel\" type=\"text\" placeholder=\"전화번호를 입력하세요\"></li>\r\n");
      out.write("									<li><input name=\"address\" type=\"text\" placeholder=\"집주소를 입력하세요\"></li>\r\n");
      out.write("									<li><input type=\"submit\" value=\"JoinUs\" class=\"button fit\"></li>\r\n");
      out.write("								</form>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</nav>			\r\n");
      out.write("				<!-- Banner -->\r\n");
      out.write("					<section id=\"banner\" class=\"major\">\r\n");
      out.write("						<div class=\"inner\">\r\n");
      out.write("							<header class=\"major\">\r\n");
      out.write("									\r\n");
      out.write("							");
if(vo==null){ 
      out.write("\r\n");
      out.write("							<h1>로그인 한 세션아이디를 출력해주세요</h1>\r\n");
      out.write("							");
}else{ 
      out.write("\r\n");
      out.write("							<h1>");
      out.print(vo.getEmail() );
      out.write("님 환영합니다.</h1>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("									<!-- 계발 시 바로 보면 오류나서 if문써 사용자 입장에선 오류안나? -->\r\n");
      out.write("									\r\n");
      out.write("									\r\n");
      out.write("									<!-- 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오.\r\n");
      out.write("									 ex)smart님 환영합니다 -->\r\n");
      out.write("								\r\n");
      out.write("							</header>\r\n");
      out.write("							<div class=\"content\">\r\n");
      out.write("								<p>아래는 지금까지 배운 웹 기술들입니다.<br></p>\r\n");
      out.write("								<ul class=\"actions\">\r\n");
      out.write("									<li><a href=\"#one\" class=\"button next scrolly\">확인하기</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</section>\r\n");
      out.write("\r\n");
      out.write("				<!-- Main -->\r\n");
      out.write("					<div id=\"main\">\r\n");
      out.write("\r\n");
      out.write("						<!-- One -->\r\n");
      out.write("							<section id=\"one\" class=\"tiles\">\r\n");
      out.write("								<article>\r\n");
      out.write("									<span class=\"image\">\r\n");
      out.write("										<img src=\"images/pic01.jpg\" alt=\"\" />\r\n");
      out.write("									</span>\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h3><a href=\"#\" class=\"link\">HTML</a></h3>\r\n");
      out.write("										<p>홈페이지를 만드는 기초 언어</p>\r\n");
      out.write("									</header>\r\n");
      out.write("								</article>\r\n");
      out.write("								<article>\r\n");
      out.write("									<span class=\"image\">\r\n");
      out.write("										<img src=\"images/pic02.jpg\" alt=\"\" />\r\n");
      out.write("									</span>\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h3><a href=\"#\" class=\"link\">CSS</a></h3>\r\n");
      out.write("										<p>HTML을 디자인해주는 언어</p>\r\n");
      out.write("									</header>\r\n");
      out.write("								</article>\r\n");
      out.write("								<article>\r\n");
      out.write("									<span class=\"image\">\r\n");
      out.write("										<img src=\"images/pic03.jpg\" alt=\"\" />\r\n");
      out.write("									</span>\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h3><a href=\"#\" class=\"link\">Servlet/JSP</a></h3>\r\n");
      out.write("										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>\r\n");
      out.write("									</header>\r\n");
      out.write("								</article>\r\n");
      out.write("								<article>\r\n");
      out.write("									<span class=\"image\">\r\n");
      out.write("										<img src=\"images/pic04.jpg\" alt=\"\" />\r\n");
      out.write("									</span>\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h3><a href=\"#\" class=\"link\">JavaScript</a></h3>\r\n");
      out.write("										<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>\r\n");
      out.write("									</header>\r\n");
      out.write("								</article>\r\n");
      out.write("								<article>\r\n");
      out.write("									<span class=\"image\">\r\n");
      out.write("										<img src=\"images/pic05.jpg\" alt=\"\" />\r\n");
      out.write("									</span>\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h3><a href=\"#\" class=\"link\">MVC</a></h3>\r\n");
      out.write("										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>\r\n");
      out.write("									</header>\r\n");
      out.write("								</article>\r\n");
      out.write("								<article>\r\n");
      out.write("									<span class=\"image\">\r\n");
      out.write("										<img src=\"images/pic06.jpg\" alt=\"\" />\r\n");
      out.write("									</span>\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h3><a href=\"#\" class=\"link\">Web Project</a></h3>\r\n");
      out.write("										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>\r\n");
      out.write("									</header>\r\n");
      out.write("								</article>\r\n");
      out.write("							</section>\r\n");
      out.write("					<!-- Two -->\r\n");
      out.write("							<section id=\"two\">\r\n");
      out.write("								<div class=\"inner\">\r\n");
      out.write("									<header class=\"major\">\r\n");
      out.write("										<h2>나에게 온 메세지 확인하기</h2>\r\n");
      out.write("									</header>\r\n");
      out.write("									<p></p>\r\n");
      out.write("									<ul class=\"actions\">	\r\n");
      out.write("											<li>로그인을 하세요.</li>\r\n");
      out.write("									</ul>\r\n");
      out.write("								</div>\r\n");
      out.write("							</section>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				<!-- Contact -->\r\n");
      out.write("					<section id=\"contact\">\r\n");
      out.write("						<div class=\"inner\">\r\n");
      out.write("							<section>\r\n");
      out.write("								<form>\r\n");
      out.write("								<div class=\"field half first\">\r\n");
      out.write("										<label for=\"name\">Name</label>\r\n");
      out.write("										<input type=\"text\" id=\"name\" placeholder=\"보내는 사람 이름\" />\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"field half\">\r\n");
      out.write("										<label for=\"email\">Email</label>\r\n");
      out.write("										<input type=\"text\" id=\"email\" placeholder=\"보낼 사람 이메일\"/>\r\n");
      out.write("									</div>\r\n");
      out.write("\r\n");
      out.write("									<div class=\"field\">\r\n");
      out.write("										<label for=\"message\">Message</label>\r\n");
      out.write("										<textarea  id=\"message\" rows=\"6\"></textarea>\r\n");
      out.write("									</div>\r\n");
      out.write("									<ul class=\"actions\">\r\n");
      out.write("										<li><input type=\"submit\" value=\"Send Message\" class=\"special\" /></li>\r\n");
      out.write("										<li><input type=\"reset\" value=\"Clear\" /></li>\r\n");
      out.write("									</ul>\r\n");
      out.write("								</form>\r\n");
      out.write("							</section>\r\n");
      out.write("							\r\n");
      out.write("							<section class=\"split\">\r\n");
      out.write("								<section>\r\n");
      out.write("									<div class=\"contact-method\">\r\n");
      out.write("										<span class=\"icon alt fa-envelope\"></span>\r\n");
      out.write("							<h3>Email</h3>\r\n");
      out.write("							\r\n");
      out.write("							");
if(vo==null){ 
      out.write("\r\n");
      out.write("							<a href=\"#\">로그인 한 사람의 이메일을 출력</a>\r\n");
      out.write("							");
}else{ 
      out.write("\r\n");
      out.write("							<a>");
      out.print(vo.getEmail() );
      out.write("</a>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("											\r\n");
      out.write("							<!-- 로그인 한 사용자의 이메일을 출력하시오 -->\r\n");
      out.write("									</div>\r\n");
      out.write("								</section>\r\n");
      out.write("								<section>\r\n");
      out.write("									<div class=\"contact-method\">\r\n");
      out.write("										<span class=\"icon alt fa-phone\"></span>\r\n");
      out.write("										\r\n");
      out.write("							<h3>Phone</h3>\r\n");
      out.write("							");
if(vo==null){ 
      out.write("\r\n");
      out.write("							<span>로그인 한 사람의 전화번호를 출력</span>	\r\n");
      out.write("							");
}else{ 
      out.write("\r\n");
      out.write("							<span>");
      out.print(vo.getTel() );
      out.write("</span>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("														\r\n");
      out.write("											\r\n");
      out.write("											<!-- 로그인 한 사용자의 전화번호를 출력하시오 -->							\r\n");
      out.write("									</div>\r\n");
      out.write("								</section>\r\n");
      out.write("								<section>\r\n");
      out.write("									<div class=\"contact-method\">\r\n");
      out.write("										<span class=\"icon alt fa-home\"></span>\r\n");
      out.write("										\r\n");
      out.write("							<h3>Address</h3>\r\n");
      out.write("							");
if(vo==null){ 
      out.write("\r\n");
      out.write("							<span>로그인 한 사람의 집주소를 출력</span>\r\n");
      out.write("							");
}else{ 
      out.write("\r\n");
      out.write("							<span>");
      out.print(vo.getAddress() );
      out.write("</span>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("									\r\n");
      out.write("										\r\n");
      out.write("											\r\n");
      out.write("											<!-- 로그인 한 사용자의 집주소를 출력하시오 -->\r\n");
      out.write("									</div>\r\n");
      out.write("								</section>\r\n");
      out.write("							</section>					\r\n");
      out.write("						</div>\r\n");
      out.write("					</section>\r\n");
      out.write("\r\n");
      out.write("				<!-- Footer -->\r\n");
      out.write("					<footer id=\"footer\">\r\n");
      out.write("						<div class=\"inner\">\r\n");
      out.write("							<ul class=\"icons\">\r\n");
      out.write("								<li><a href=\"#\" class=\"icon alt fa-twitter\"><span class=\"label\">Twitter</span></a></li>\r\n");
      out.write("								<li><a href=\"#\" class=\"icon alt fa-facebook\"><span class=\"label\">Facebook</span></a></li>\r\n");
      out.write("								<li><a href=\"#\" class=\"icon alt fa-instagram\"><span class=\"label\">Instagram</span></a></li>\r\n");
      out.write("								<li><a href=\"#\" class=\"icon alt fa-github\"><span class=\"label\">GitHub</span></a></li>\r\n");
      out.write("								<li><a href=\"#\" class=\"icon alt fa-linkedin\"><span class=\"label\">LinkedIn</span></a></li>\r\n");
      out.write("							</ul>\r\n");
      out.write("							<ul class=\"copyright\">\r\n");
      out.write("								<li>&copy; Untitled</li><li>Design: <a href=\"https://html5up.net\">HTML5 UP</a></li>\r\n");
      out.write("							</ul>\r\n");
      out.write("						</div>\r\n");
      out.write("					</footer>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		<!-- Scripts -->\r\n");
      out.write("			<script src=\"assets/js/jquery.min.js\"></script>\r\n");
      out.write("			<script src=\"assets/js/jquery.scrolly.min.js\"></script>\r\n");
      out.write("			<script src=\"assets/js/jquery.scrollex.min.js\"></script>\r\n");
      out.write("			<script src=\"assets/js/skel.min.js\"></script>\r\n");
      out.write("			<script src=\"assets/js/util.js\"></script>\r\n");
      out.write("			<!--[if lte IE 8]><script src=\"assets/js/ie/respond.min.js\"></script><![endif]-->\r\n");
      out.write("			<script src=\"assets/js/main.js\"></script>\r\n");
      out.write("			\r\n");
      out.write("			<script>\r\n");
      out.write("			\r\n");
      out.write("				function idCheck() {\r\n");
      out.write("				// 요소의 실제 값을 가지고 오는 방법\r\n");
      out.write("				// 1. innerText : 태그 사이에 텍스트를 가지고 오는 방법 <p><span>스마트 </span>그리드</p> ->스마트그리드\r\n");
      out.write("				// 2. innerHTML : 태그 사이에 모든 요소를 가지고 오는 방법 <p><span>sp</span></p> -> <span>sp</span>\r\n");
      out.write("				// 3. value : input 태그의 value 속성값을 가지고 올때\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("				var input = document.getElementById(\"input_id\");\r\n");
      out.write("				\r\n");
      out.write("				/*\r\n");
      out.write("				alert(input.value); // -> vanilla js 사용\r\n");
      out.write("				\r\n");
      out.write("				alert($('#input_id').val()); // jquery 사용\r\n");
      out.write("				*/\r\n");
      out.write("				\r\n");
      out.write("				// ajax\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					type : \"post\", // 데이터 전송(요청) 방식\r\n");
      out.write("					data : {\"email\": input.value}, // 전송하는 데이터\r\n");
      out.write("					url : \"IdCheckService\", // 데이터를 전송하는 (요청하는) 서퍼페이지 url\r\n");
      out.write("					dataType : \"text\", // 응답 데이터의 형식\r\n");
      out.write("					success : function(data) { //통신 성공\r\n");
      out.write("						// alert(data)\r\n");
      out.write("						\r\n");
      out.write("						var sp_result = document.getElementById(\"sp_result\");\r\n");
      out.write("						\r\n");
      out.write("						if(data==\"true\"){\r\n");
      out.write("							\r\n");
      out.write("							sp_result.innerText = \"사용불가능한 아이디\";\r\n");
      out.write("							input.value=\"\";\r\n");
      out.write("							\r\n");
      out.write("						}else{\r\n");
      out.write("							\r\n");
      out.write("							$(\"#sp_result\").text(\"사용가능한 아이디\");\r\n");
      out.write("							\r\n");
      out.write("						}\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("					}, \r\n");
      out.write("					error : function () { // 통신 실패\r\n");
      out.write("						alert(\"통신실패\")\r\n");
      out.write("					}\r\n");
      out.write("										\r\n");
      out.write("				});\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("					\r\n");
      out.write("				}\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			</script>\r\n");
      out.write("			\r\n");
      out.write("\r\n");
      out.write("	</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
