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
	
	//2. ��û ����� ó���� �� �ִ� method�� Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ �ʿ䰡 �ִٸ� �������� �����ϰ� ��½�Ʈ�����
		
		//3. ���� ó��
		String param = request.getParameter("param");
		
		if(param==null) {
			param="����ȣ��";
		}
		//s1. ���Ǿ��
		HttpSession session= request.getSession();
		//s2. interval����(web.xml���� �ַ���)
		session.setMaxInactiveInterval(60*2);

		//s3. ������ ���� �Ҵ� => �Ҵ�� ���� � ������������ ��밡��
		session.setAttribute("paramData", param);
		
		RequestDispatcher rd = request.getRequestDispatcher("day0429/session_view.jsp");
		rd.forward(request, response);
	}

}
