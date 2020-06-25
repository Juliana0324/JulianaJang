package chap02.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.bean.Member;
import chap02.controller.*;


public class JoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// <% %>���� ó���ϴ� ���� �̰����� ���� ó��
		// forward�� ��������� �������� ��ġ�� ����
		JoinController controller=new JoinController();
		String method=req.getMethod();
		
		if(method.equalsIgnoreCase("get")) 
			return controller.joinForm();
		else if(method.equalsIgnoreCase("post"))
			return controller.register(new Member(req), req);
		else
			return "/WEB-INF/view/form/join.jsp";
	}

	}
