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
	
	//점수등록 화면 열어주는 처리하는 요청메소드
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
	
	//점수 전체 조회
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list: Get");
		model.addAttribute("sList", service.selectAllScores());
	}
	
	//점수 삭제
	@GetMapping("/delete")
	public String delete(int stuNum, RedirectAttributes ra) {
		System.out.println("삭제할 학번: "+ stuNum);
		service.deleteScore(stuNum);
		ra.addFlashAttribute("message", "delSuccess");
		return "redirect:/score/list";
	}
	
	@GetMapping("/search")
	public void search() {
		System.out.println("/score/search: GET");
	}
	
	//점수 개별 조회
	@GetMapping("/selectOne")
	public String selectOne(String stuNum, Model model, RedirectAttributes ra) {
		System.out.println("/score/selectOne: GET");
		List<ScoreVO> list = service.selectAllScores();
		
		try {
			int n=Integer.parseInt(stuNum);
			if(n>list.size()) {
				ra.addFlashAttribute("msg", "학번정보가 없습니다.");
				return "score/search-result";
			}
			
			else {
				model.addAttribute("stu", service.selectOne(n));
				return "score/search-result";
				
			}
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			ra.addFlashAttribute("msg", "숫자로만 입력하세요!");
			return "redirect:/score/search";
		}
	}
	
}
