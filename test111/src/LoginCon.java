

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test111.MDAO;
import test111.MDTO;




@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
request.setCharacterEncoding("euc-kr");
		
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MDAO mdao = new MDAO();
		MDTO mdto = mdao.login_member(id, pw);
		
		
		
		if(mdto != null) {
			
			// ���� ��ü ����
			HttpSession session =request.getSession();
			
			// ���� �� ���� - ��ü�� ���� ��κ� ��?
			session.setAttribute("member", mdto);
			
					
			response.sendRedirect("main.jsp");
		}else {
			
			
			
		}
		
		
	}

}
