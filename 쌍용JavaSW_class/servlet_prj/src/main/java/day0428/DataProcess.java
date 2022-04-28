package day0428;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class DataProcess extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ó���� ������-> ���߰�ü ���
		String[] url = {"daum.net","naver.com","google.com", "nate.com", "youtube.com"};
	
		//scope��ü ���
		TestVO tVO= new TestVO("������", "�����е� ������ ������Ʈ �������ּ���");
		
		//scope��ü ����(�̵����������� ����� �� �ֵ��� request�� session���)
		request.setAttribute("site_url", url);
		request.setAttribute("vo", tVO);
		
		// �̵��� ������ URI ���� 
		//http://localhost/servlet_prj/day0428/data_view.jsp => URI���:   day0428/data_view.jsp
		RequestDispatcher rd =request.getRequestDispatcher("day0428/data_view.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
