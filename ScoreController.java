package study.spring.myapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import study.spring.myapp.model.ScoreVO;
import study.spring.myapp.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private IScoreService service;
	
	//������� ȭ�� �����ִ� ó���ϴ� ��û�޼ҵ�
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register: Get");
		return "score/write-form";
	}
	
	@PostMapping("/register")
	public String register(ScoreVO scores) {
		System.out.println("/score/register: Post");
		System.out.println("Controller param : "+scores);
		
		service.insertScore(scores);
		return "score/write-result";
	}
	
	//���� ��ü ��ȸ
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list: Get");
		model.addAttribute("sList", service.selectAllScores());
	}
	
	//���� ����
	@GetMapping("/delete")
	public String delete(int stuNum, RedirectAttributes ra) {
		System.out.println("������ �й�: "+ stuNum);
		service.deleteScore(stuNum);
		ra.addFlashAttribute("message", "delSuccess");
		return "redirect:/score/list";
	}
	
	@GetMapping("/search")
	public void search() {
		System.out.println("/score/search: GET");
	}
	
	//���� ���� ��ȸ
	@GetMapping("/selectOne")
	public String selectOne(String stuNum, Model model, RedirectAttributes ra) {
		System.out.println("/score/selectOne: GET");
		List<ScoreVO> list = service.selectAllScores();
		
		try {
			int n=Integer.parseInt(stuNum);
			if(n>list.size()) {
				ra.addFlashAttribute("msg", "�й������� �����ϴ�.");
				return "score/search-result";
			}
			
			else {
				model.addAttribute("stu", service.selectOne(n));
				return "score/search-result";
				
			}
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			ra.addFlashAttribute("msg", "���ڷθ� �Է��ϼ���!");
			return "redirect:/score/search";
		}
	}
	
}
