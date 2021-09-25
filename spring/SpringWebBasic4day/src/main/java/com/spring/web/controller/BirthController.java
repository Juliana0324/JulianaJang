package study.spring.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import study.spring.myapp.model.BirthVO;

@Controller

public class BirthController {
	//생일입력폼
	@GetMapping("/birth")
	public String birthForm() {
		return "birth/birth-form";
	}
	
	@PostMapping("/birth")
	public String sendBirth(@ModelAttribute("birth")BirthVO birth) {
		String birthDay = birth.getYear()+birth.getMonth()+birth.getDay();
		System.out.println(birthDay);
		return"birth/birth-result";
	}
	
}
