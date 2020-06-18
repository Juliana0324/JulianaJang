import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class JoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Get��� ��û�� �Խ��ϴ�.");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//req: Ŭ���̾�Ʈ�� ���� ������ �� ������ ���� ��ü
		String name= request.getParameter("m_name");
		String age= request.getParameter("m_age");
		String email= request.getParameter("m_email");
		
		//resp: ������������ �����ѵ� ����
		response.setCharacterEncoding("EUC-KR");
		response.getWriter().append("<html><h3>Post��� ��û�� �Խ��ϴ�.</h3>")
		.append("�̸�: "+name+"<br>")
		.append("����: "+age+"<br>")
		.append("�̸���: "+email+"<br></html>")
		;
	}
}
