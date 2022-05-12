package kr.co.sist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.DataService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Session사용
 * @author user
 *
 */
@Controller
public class SessionController {
	
	@RequestMapping(value="/day0512/session.do", method=GET)
	public String sessionDo(HttpSession session) {
		System.out.println(session);
		//값 설정
		session.setAttribute("name", "장정우");
		DataService ds=new DataService();
		
		session.setAttribute("data", ds.searchData());
		
		return "day0512/use_session";
	}
	
}
