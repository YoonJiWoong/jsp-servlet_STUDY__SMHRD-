

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test111.MDAO;


@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		// ��û ������ �޾��ֱ�
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		MDAO mdao = new MDAO();
		
		int cnt = mdao.insert_member(id, pw);
		

		if(cnt>0) {
			System.out.println("���Լ���");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			
			request.setAttribute("id",id);  
			
			rd.forward(request, response); 
		
			
		}else {
			System.out.println("���Խ���");
			response.sendRedirect("main.jsp");
			
			
		}
	
		
	}

}