package chap09.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap09.controller.CommandHandler;
import chap09.service.IndexService;

public class IndexHandler implements CommandHandler{
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setAttribute("ulist", IndexService.getAllUser());

		//controller : 사용자의 요청에 따라 
		//handler 패키지 : 요청을 받으면 어떤 비즈니스 로직을 수행한뒤 어느 페이지로 갈지 결ㅈㅇ
		// service 페키지: 요청ㅇ을 받으면 수행해야하는 비즈니스 로징(conn)
		//dao 패키지: DB의 CRUD기능을 구현하는 객체>(pstmt, rs)
		//dto 패키지: 데이터를 편하게 전달하기 위한 객체()
		
		
		return "/WEB-INF/view/index.jsp";

}
}
