/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2021-12-03 06:19:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import test111.BVO;
import test111.BDAO;
import java.util.ArrayList;
import test111.MDAO;
import test111.MDTO;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("test111.BVO");
    _jspx_imports_classes.add("test111.BDAO");
    _jspx_imports_classes.add("test111.MDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("test111.MDTO");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
 	
MDTO mdto =(MDTO)session.getAttribute("member");

BDAO dao = new BDAO();
ArrayList<BVO> al = dao.noContents();
int cnt = 1;





      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"tm-row\">\r\n");
      out.write("                <div class=\"tm-col-left\"></div>\r\n");
      out.write("                <main class=\"tm-col-right\">\r\n");
      out.write("                    <section class=\"tm-content\">\r\n");
      out.write("                        		<h1 style=\"text-align:center\"><i>massage board</i></h1>\r\n");
      out.write("                        		<hr class=\"mb-5\">\r\n");
      out.write("                               <table border=\"1\">\r\n");
      out.write("                               	<tr>\r\n");
      out.write("                               		<th width=\"50\" height=\"50\" style=\"text-align:center\">번호</th>\r\n");
      out.write("                               		<th width=\"350\" height=\"50\" style=\"text-align:center\">제목</th>\r\n");
      out.write("                               		<th width=\"130\" height=\"50\" style=\"text-align:center\">날짜</th>\r\n");
      out.write("                               		<th width=\"130\" height=\"50\" style=\"text-align:center\">회원아이디</th>\r\n");
      out.write("                               	</tr>\r\n");
      out.write("                               	");
for(BVO svo : al){ 
      out.write("\r\n");
      out.write("                               	<form action=\"ServiceCenterDetail.jsp\" method=\"post\">\r\n");
      out.write("                               	<tr>\r\n");
      out.write("                               	<input type=\"hidden\" name=\"board_num\" value=\"");
      out.print(svo.getBoard_num() );
      out.write("\">\r\n");
      out.write("                               		<td  width=\"50\" height=\"50\" style=\"text-align:center\">");
      out.print(cnt++ );
      out.write("</td>\r\n");
      out.write("                               		<td  width=\"350\" height=\"50\" style=\"text-align:center\"><button id=titleboard type=\"submit\">");
      out.print(svo.getBoard_title() );
      out.write("</button></td>\r\n");
      out.write("                               		<td  width=\"130\" height=\"50\" style=\"text-align:center\">");
      out.print(svo.getBoard_date() );
      out.write("</td>\r\n");
      out.write("                               		<td  width=\"130\" height=\"50\" style=\"text-align:center\">");
      out.print(svo.getM_id() );
      out.write("</td>\r\n");
      out.write("                               		\r\n");
      out.write("                               	</tr>\r\n");
      out.write("                               	</form>\r\n");
      out.write("                               	");
} 
      out.write("\r\n");
      out.write("                               </table>\r\n");
      out.write("                               <BR>\r\n");
      out.write("                               \r\n");
      out.write("                              <button><a href=\"Write.jsp\" class=\"btn btn-primary\">글쓰기</a></button>\r\n");
      out.write("                            \r\n");
      out.write("                    </section>\r\n");
      out.write("                </main>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
