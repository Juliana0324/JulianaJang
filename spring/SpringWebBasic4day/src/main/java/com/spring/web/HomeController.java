package com.spring.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HomeCon 작동!");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//session.setAttribute // request.setAttribute
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	//test.jsp를 열기 위한 요청 메서드 구성
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test() {
		System.out.println("/test 요청이 들어옴: GET방식!!!");
		//return "test";
	}
	
}





