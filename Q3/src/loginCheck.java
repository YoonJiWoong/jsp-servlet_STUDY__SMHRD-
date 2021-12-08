

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		if(id.equals("smhrd")&&pw.equals("12345")){
			session.setAttribute("nickname", "辑措锐"); //技记积己
			response.sendRedirect("main.jsp"); // main.jsp
		}else{
			response.sendRedirect("loginForm.html");
			
		}
		
		
		
		
	}

}
