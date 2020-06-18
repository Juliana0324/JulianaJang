package chap01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class Controller01 extends HttpServlet{

	// Call-back 메서드 : 어떤 특정 상황이 발생하면 불러주는 함수 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNum=req.getParameter("pageNum");
		int nextPage=404;
		
		try {
			nextPage=Integer.parseInt(pageNum);
			
		}catch(Exception e) {}

		//servlet에서 <jsp: forward page="path"를 이용하기>
		RequestDispatcher dispatcher
			=req.getRequestDispatcher("/forward/view/"+nextPage+".jsp");
		dispatcher.forward(req,(ServletResponse) resp);
	}		
	

}
