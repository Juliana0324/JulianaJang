package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("resCon")
@RequestMapping("/response")
public class ResponseController {

	@GetMapping("/res-ex01")
	public void resEx01() {

	}

	//1. Model객체를 사용하여 화면에 데이터 전송하기.
	/*@GetMapping("/test")
	public void test(@RequestParam("age") int age, 
						Model model) {
		model.addAttribute("nick", "뽀삐");
		model.addAttribute("age", age);
	}*/
	
	//2. @ModelAttribute를 사용한 화면에 데이터 전송처리.
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, 
			Model model) {
		model.addAttribute("nick", "뽀삐");
		//model.addAttribute("age", age);
	}
	
	//3. ModelAndView객체를 활용한 처리
	@GetMapping("/test2") 
	public ModelAndView test2() {
		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("userName", "박영희");
//		mv.setViewName("/response/test2");
//		
//		return mv;
		
		return new ModelAndView("/response/test2", "userName", "김철수");
	}

}







