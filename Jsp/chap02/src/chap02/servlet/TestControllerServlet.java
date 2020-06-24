package chap02.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ 
				"/abc", 
				"/abcd"
		})
public class TestControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/view.testView.jsp").forward(request,response);
	
		//�����̷�Ʈ�� WEB-INF�� �� �� �ֳ���
		response.sendRedirect("/chap02/test/jsp");
	}

}
