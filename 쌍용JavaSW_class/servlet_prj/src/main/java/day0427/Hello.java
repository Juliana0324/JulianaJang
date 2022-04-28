package day0427;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@SuppressWarnings("serial")
//1. HttpServlet���
public class Hello extends HttpServlet {

	//2. ��û����� ó���� �� �ִ� method Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. �����ڿ��� ������ ������ ����
		response.setContentType("text/html;charset=UTF-8");
		
		//4. ��� ��Ʈ�� ���
		PrintWriter out=response.getWriter();
		
		//5. �����ڿ��� ����� �������.
		out.println("<!DOCTYPE>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�ȳ� ����</title>");
		out.println("</head>");
		out.println("<body>");
		
		String name="�׽�Ʈ";
		out.println("<strong>");
		out.println(name);
		out.println("</strong>�� �ȳļ���");

		out.println("</body>");
		out.println("</html>");
	}

}
