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
		//처리된 데이터-> 스콥객체 담기
		String[] url = {"daum.net","naver.com","google.com", "nate.com", "youtube.com"};
	
		//scope객체 담기
		TestVO tVO= new TestVO("김진영", "조원분들 열심히 프로젝트 수행해주세요");
		
		//scope객체 저장(이동페이지에서 사용할 수 있도록 request나 session사용)
		request.setAttribute("site_url", url);
		request.setAttribute("vo", tVO);
		
		// 이동할 페이지 URI 설정 
		//http://localhost/servlet_prj/day0428/data_view.jsp => URI경로:   day0428/data_view.jsp
		RequestDispatcher rd =request.getRequestDispatcher("day0428/data_view.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
