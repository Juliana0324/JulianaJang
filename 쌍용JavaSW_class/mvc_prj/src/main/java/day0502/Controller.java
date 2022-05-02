package day0502;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 진입점인 controller
 * @author user
 *
 */
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반클래스에서 웹의 파라미터를 처리하는 코드
		WebParam wo=new WebParam();
		
		wo.method(request);
		
		RequestDispatcher rd= request.getRequestDispatcher("day0502/view.jsp");
		rd.forward(request, response);
	}


}
