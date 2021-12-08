package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession(); // ���� ��ü ����
		MemberVO vo = (MemberVO)session.getAttribute("member"); // ���� �α����� �������(������) ����
		
		String id =  vo.getId();
	
		String pw = request.getParameter("pw");
		String age = request.getParameter("age"); 
		String gender = request.getParameter("gender");
		String height = request.getParameter("height");
		String kg = request.getParameter("kg");
		String bmi = request.getParameter("bmi");
		
		System.out.println(age);
		
		
		MemberDAO dao = new MemberDAO();
		
		
		if(pw.equals("")) {
			pw=vo.getPw();
		}
		if(age.equals("")) {
			age=vo.getAge();
		}
		if(gender.equals("")) {
			gender=vo.getGender();
		}
		if(height.equals("")) {
			height=vo.getHeight();
		}
		if(kg.equals("")) {
			kg=vo.getKg();
		}
		if(bmi.equals("")) {
			kg=vo.getBMI();
		}
	
		
		int cnt=dao.Update(pw, age, gender, height, kg, id, bmi);
		
		if(cnt>0) {
			System.out.println("��������");
			response.sendRedirect("index2.jsp");
			
		}else {
			System.out.println("��������");
			response.sendRedirect("index2.jsp");
		}
		
		
		
		
		
		
	}

}
