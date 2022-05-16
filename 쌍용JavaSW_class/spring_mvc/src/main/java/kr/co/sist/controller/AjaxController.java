package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.service.AjaxService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AjaxController {
	
	@RequestMapping(value="/day0513/ajax.do", method=GET)
	public String ajaxDo(Model model) {
		AjaxService ajs =new AjaxService();
		
		model.addAttribute("data", ajs.createJSON());
		
		return "day0513/ajax_result";
	}

	@ResponseBody
	@RequestMapping(value="/day0516/ajax.do", method=GET, produces = "application/json;charset=UTF-8")
	public String ajax1() {
		AjaxService as = new AjaxService();
		//@ResponseBody가 정의되면 View페이지명이 아닌 Json이 return 되어야한다
		
		return as.createJSON();
	}
}
