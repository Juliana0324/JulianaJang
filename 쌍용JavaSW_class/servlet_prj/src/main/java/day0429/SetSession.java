package day0429;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SetSession extends HttpServlet {
	
	//2. 요청 방식을 처리할 수 있는 method를 Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답할 필요가 있다면 응답방식을 설정하고 출력스트림얻기
		
		//3. 업무 처리
		String param = request.getParameter("param");
		
		if(param==null) {
			param="최초호출";
		}
		//s1. 세션얻기
		HttpSession session= request.getSession();
		//s2. interval설정(web.xml에서 주로함)
		session.setMaxInactiveInterval(60*2);

		//s3. 세션의 값을 할당 => 할당된 값은 어떤 페이지에서든 사용가능
		session.setAttribute("paramData", param);
		
		RequestDispatcher rd = request.getRequestDispatcher("day0429/session_view.jsp");
		rd.forward(request, response);
	}

}
