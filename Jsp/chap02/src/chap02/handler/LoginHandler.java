package chap02.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.controller.LoginController;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//<%%> ���� ó���ϴ����� �̰����� ���� ó��
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
