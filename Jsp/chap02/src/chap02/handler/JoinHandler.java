package chap02.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// <% %>���� ó���ϴ� ���� �̰����� ���� ó��
		// forward�� ��������� �������� ��ġ�� ����
		return "/WEB-INF/view/join.jsp";
	}

}
