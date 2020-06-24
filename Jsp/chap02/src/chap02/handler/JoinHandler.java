package chap02.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// <% %>에서 처리하던 것을 이곳에서 전부 처리
		// forward로 보내고싶은 페이지의 위치를 리턴
		return "/WEB-INF/view/join.jsp";
	}

}
