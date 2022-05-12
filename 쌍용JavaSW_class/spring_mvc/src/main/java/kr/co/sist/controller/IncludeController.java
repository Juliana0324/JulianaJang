package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncludeController {

	
	@RequestMapping(value="/day0512/include_views.do", method=GET)
	public String webInf() {
		return "day0512/include_inf"; 
	}
	@RequestMapping(value="/day0512/include_webapp.do", method=GET)
	public String doInclude() {
		return "day0512/include_do"; 
	}
}
