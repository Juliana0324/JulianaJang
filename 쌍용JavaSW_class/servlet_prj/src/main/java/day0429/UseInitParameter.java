package day0429;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * DD에 설정된 값을 받는 일
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseInitParameter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Servlet Config얻기 => 특정 서블릿에서만 값을 얻을수 있는 객체
		ServletConfig sc= getServletConfig();
		
		//2. 모든 initParameter의 이름 받기
//		Enumeration<String> en=sc.getInitParameterNames();
//		while(en.hasMoreElements()) {
//			System.out.println(sc.getInitParameter(en.nextElement()));
//		}
		
		String url=sc.getInitParameter("url");
		String id=sc.getInitParameter("username");
		String pass=sc.getInitParameter("password");
		
		String connectionURL = "jdbc:oracle:thin:@"+url+":1521:orcl";
		
		System.out.println(url);
		System.out.println(connectionURL);
		System.out.println(id);
		System.out.println(pass);
		
		
	}

}
