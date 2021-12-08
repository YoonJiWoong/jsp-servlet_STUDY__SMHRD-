package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/GetSensor")
public class GetSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = Integer.parseInt(request.getParameter("count"));
		String s_id = request.getParameter("code");
		System.out.println("count : "+count);
		System.out.println("s_id : "+s_id);
		SensorDAO dao = new SensorDAO();
		
		SensorVO vo = dao.update2(count, s_id);
		String result = new Gson().toJson(vo);		
		PrintWriter out = response.getWriter();
	/*	out.print(result);
		*/
	
		
		
	}

}
