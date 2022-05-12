package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MoveController {
	
	@RequestMapping(value="/day0512/do_move.do", method=GET)
	public String doMove() {
		System.out.println("do ���û ������");
		
//		return "../index.do"; //ViewResolver�� ���� -> Web-INF/views/../index.do.jsp
		return "redirect:../index.do"; //ViewResolver�� ���� x
	}

	@RequestMapping(value="/day0512/jsp_move.do", method=GET)
	public String jspMove() {
		System.out.println("jsp�� ���û ������");

//		return "redirect:../jsp_result.jsp"; //ViewResolver�� ���� x
		return "redirect:http://localhost/spring_mvc/jsp_result.jsp";
	}

	@RequestMapping(value="/day0512/forward_a.do", method=GET)
	public String doDirectMove() {
		System.out.println("do�� ������û������");
		return "forward:forward_b.do"; //viewResolver�� ���� ����
	}
	@RequestMapping(value="/day0512/forward_b.do", method=GET)
	public String doDirectMoveB() {
		System.out.println("����");
		return "day0512/forward_b_result"; //viewResolver�� ����� �̵� WEB-INF/views
	}
	
	
}
