

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap09.controller.CommandHandler;
import chap09.handler.IndexHandler;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private Map<String,CommandHandler> cmdMap= new HashMap<>();
	
	
	@Override
	public void init() throws ServletException {
		cmdMap.put("/index", new IndexHandler());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("모든요청은 이곳으로 이동");
//		System.out.println("클라이언트가 들어올때 요청한 주소" +req.getRequestURI());
//		System.out.println("이 프로젝트의 ContextPath" +req.getContextPath());
//    
		String cmd= req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("주소로 부터 잘라낸 커맨드: "+ cmd);
		String nextPage = null;
		try {
		nextPage= cmdMap.get(cmd).process(req, resp);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		if (nextPage !=null) {
			req.getRequestDispatcher(nextPage).forward(req,resp);
		}
	}

}
