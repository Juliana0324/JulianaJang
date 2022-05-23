package kr.co.sist.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.dao.DiDAO;
import kr.co.sist.service.DiService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class DiController {
	private DiDAO dao;
	private DiService service;
	
	@RequestMapping(value="/day0518/di.do", method=GET)
	public String requestDi(Model model) {
		
		//1. SpringContainer 생성
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/controller/applicationContext.xml");
		
		//DAO를 의존성 주입받는 서비스 사용 
		service=ac.getBean(DiService.class);
		List<String> list = service.searchData();
		
		model.addAttribute("data", list);
		
		//3. Spring COntainer 닫기
		((ClassPathXmlApplicationContext)ac).close();
		return "day0518/di";
	}
	
}
