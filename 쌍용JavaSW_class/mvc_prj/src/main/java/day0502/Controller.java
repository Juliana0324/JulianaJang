package day0502;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��� �������� controller
 * @author user
 *
 */
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�Ϲ�Ŭ�������� ���� �Ķ���͸� ó���ϴ� �ڵ�
		WebParam wo=new WebParam();
		
		wo.method(request);
		
		RequestDispatcher rd= request.getRequestDispatcher("day0502/view.jsp");
		rd.forward(request, response);
	}


}
