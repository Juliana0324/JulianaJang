package day0429;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class RemoveSession extends HttpServlet {

	//���� ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		session.removeAttribute("paramData");
		//������ �̵�
		RequestDispatcher rd= request.getRequestDispatcher("day0429/remove_view.jsp");
		rd.forward(request, response);
		
	}

}
