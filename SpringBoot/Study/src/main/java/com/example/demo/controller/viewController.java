package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.viewRepository;
import com.example.demo.vo.Members;

@Controller
public class viewController {
	
	@Autowired
	viewRepository viewRepo;
	
	@GetMapping("/")
	public String indexGo() {
		System.out.println("홈으로 슝");
		return "member/home";
	}
	
	//@PostConstruct: 서버실행시 최초에 한번 바로 호출해서 동작하게하는놈이다.
	@PostConstruct
	public void testMyBatis() {
		List<Members> members = viewRepo.allMembers();
		System.out.println("결과는? "+members);
	}
	
	@GetMapping("/insert")
	public String memberForm() {
		return "member/form";
	}
	
	@PostMapping("/insert")
	public String memberInsert(Members member, Model model) {
		viewRepo.insertMembers(member);
		model.addAttribute(member);
		
		System.out.println("/insert Post로 받기:"+ member);
		return "member/home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("Controller /list: Get들어옴");
		model.addAttribute("members", viewRepo.allMembers());
		return "member/list";
	}
	


}