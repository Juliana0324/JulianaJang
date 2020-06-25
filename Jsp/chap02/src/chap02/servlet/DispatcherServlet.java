package chap02.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.handler.CommandHandler;
import chap02.handler.*;

import chap02.handler.*;
public class DispatcherServlet extends HttpServlet {
	
	private Map<String, CommandHandler> cmdMap=new HashMap<>(); 
	
	//새로운 URL이 생길때마다 web.xml에 등록하기 싫어서 만든 서블릿
	
	@Override
	public void init() throws ServletException {
		//init() ==>servlet이 처음 생성될때 가장먼저 호출되는 함수
		System.out.println("init() 호출됨");
		cmdMap.put("/join",new JoinHandler());
		cmdMap.put("/login",new LoginHandler());
}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get,Post 모두 도착하는 함수
		//요청의 종류와 상관없이 무조건 호출되는 메서드
		//doGet,doPost,doPut.... 등으로 나누기전에 처리할 수 있는 메소드
		
		System.out.println("service() 호출됨");
		req.setCharacterEncoding("EUC-KR");
		String cmd=req.getRequestURI().replace("/chap02/mvc/","/");
		System.out.println("사용자가 원한 페이지:  "+cmd);

		String viewPage=null;
		try {
			viewPage=cmdMap.get(cmd).process(req,resp);
		}catch(Exception e) {
			viewPage=null;
		}
		if(viewPage==null) {
			req.getRequestDispatcher("/WEB-INF/error/404.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher(viewPage).forward(req, resp);
		}
		
		//cmd가  join이면 join처리
		//cmd가  login 이면 login처리
		//cmd가 ...이면 ...처리
		//여기서 /mvc/*의 모든 처리를 진행할 수도 있지만 
		//소스코드를 분할하는 것이 유지 보수 측면에서 좋다
		
		
//		
//		System.out.println("웹 서버의 Context경로: "+req.getContextPath());
//		System.out.println("사용자가 요청한 경로: "+req.getRequestURI());
//		System.out.println("사용자가 요청한 방식: "+req.getMethod());
//		System.out.println("사용자가 요청한 Query: "+req.getQueryString());
//		System.out.println("사용자의 IP주소:"+req.getRemoteAddr());
//		System.out.println("요청의 header: "+req.getHeaderNames());
//		System.out.println("요청의 파라미터들: "+req.getParameterNames());
//		System.out.println("요청에 실린 어트리뷰트들: "+req.getAttributeNames());
//		
		//getParameter(name),getAttribute(name),getHeader(name)
		
		
		//원래 service동작
		//- 요청의 method를 확인하고 알맞은 do메서드를 호출해주는 역할
		//- ex:Get박식 요청이라면 doGet호출
		//super.service(req, resp);
	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()호출됨");
	}

}
