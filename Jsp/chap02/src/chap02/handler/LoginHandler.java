package chap02.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.controller.LoginController;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//<%%> 에서 처리하던것을 이곳에서 전부 처리
			LoginController controller=new LoginController();
			switch(req.getMethod()) {
			case "GET":
				return controller.loginForm(req, resp);
			case "POST":
				return controller.loginCheck(req,resp);
				
			default:
				return "/WEB-INF/view/mvc/login.jsp";
		
	}
	}
	}
