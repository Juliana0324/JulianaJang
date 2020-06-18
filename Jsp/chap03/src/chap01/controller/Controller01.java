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

	// Call-back �޼��� : � Ư�� ��Ȳ�� �߻��ϸ� �ҷ��ִ� �Լ� 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNum=req.getParameter("pageNum");
		int nextPage=404;
		
		try {
			nextPage=Integer.parseInt(pageNum);
			
		}catch(Exception e) {}

		//servlet���� <jsp: forward page="path"�� �̿��ϱ�>
		RequestDispatcher dispatcher
			=req.getRequestDispatcher("/forward/view/"+nextPage+".jsp");
		dispatcher.forward(req,(ServletResponse) resp);
	}		
	

}
