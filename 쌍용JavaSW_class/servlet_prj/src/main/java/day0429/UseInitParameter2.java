package day0429;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * DD�� ������ ���� �޴� ��. USEInitParameter�� ���� �ڵ带 ������ �ִ�
 * ���� DD���� <init-param>�� �����Ǿ����� �ʴ�
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseInitParameter2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Servlet Config��� => Ư�� ���������� ���� ������ �ִ� ��ü
		ServletConfig sc= getServletConfig();
		
		//2. ��� initParameter�� �̸� �ޱ�
//		Enumeration<String> en=sc.getInitParameterNames();
//		while(en.hasMoreElements()) {
//			System.out.println(sc.getInitParameter(en.nextElement()));
//		}
		
		String url=sc.getInitParameter("url");
		String id=sc.getInitParameter("username");
		String pass=sc.getInitParameter("password");
		
		String connectionURL = "jdbc:oracle:thin:@"+url+":1521:orcl";
		
		System.out.println("UseInitParameter2���� ����ϴ� ��");
		System.out.println(url);
		System.out.println(connectionURL);
		System.out.println(id);
		System.out.println(pass);
		
		ServletContext sc2=getServletContext();
		
		String common_css=sc2.getInitParameter("common_css");
		String common_jquery=sc2.getInitParameter("common_jquery");

		System.out.println("context-param");
		System.out.println("���� css: "+common_css);
		System.out.println("���� jq: "+common_jquery);
		
	}

}
