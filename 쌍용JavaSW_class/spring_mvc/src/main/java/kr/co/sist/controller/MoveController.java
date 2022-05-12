package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MoveController {
	
	@RequestMapping(value="/day0512/do_move.do", method=GET)
	public String doMove() {
		System.out.println("do 재요청 보내기");
		
//		return "../index.do"; //ViewResolver가 동작 -> Web-INF/views/../index.do.jsp
		return "redirect:../index.do"; //ViewResolver가 동작 x
	}

	@RequestMapping(value="/day0512/jsp_move.do", method=GET)
	public String jspMove() {
		System.out.println("jsp로 재요청 보내기");

//		return "redirect:../jsp_result.jsp"; //ViewResolver가 동작 x
		return "redirect:http://localhost/spring_mvc/jsp_result.jsp";
	}

	@RequestMapping(value="/day0512/forward_a.do", method=GET)
	public String doDirectMove() {
		System.out.println("do로 직접요청보내기");
		return "forward:forward_b.do"; //viewResolver의 동작 막기
	}
	@RequestMapping(value="/day0512/forward_b.do", method=GET)
	public String doDirectMoveB() {
		System.out.println("응답");
		return "day0512/forward_b_result"; //viewResolver를 사용한 이동 WEB-INF/views
	}
	
	
}
