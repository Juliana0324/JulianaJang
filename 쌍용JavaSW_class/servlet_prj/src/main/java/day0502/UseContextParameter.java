package day0502;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��� servlet/JSP���� ����� �� �ִ� <context-param>���
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseContextParameter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. ServletContext���
		ServletContext sc=getServletContext();
		
		String common_css=sc.getInitParameter("common_css");
		String common_jquery=sc.getInitParameter("common_jquery");

		System.out.println("context-param");
		System.out.println("���� css: "+common_css);
		System.out.println("���� jq: "+common_jquery);
	}

}
