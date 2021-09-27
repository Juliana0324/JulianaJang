package study.spring.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import study.spring.myapp.model.BoardVO;
import study.spring.myapp.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//글 작성화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/write: Get요청");
	}
	
	//글 작성 처리
	@PostMapping("/write")
	public String write(BoardVO article) {
		service.insertArticle(article);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("articles", service.getArticles());
	}

	//글 내용보기 요청
		@GetMapping("/content")
		public void content(@ModelAttribute("boardNo") int boardNo
				, Model model) {
			System.out.println("/board/content?boardNo="+boardNo+" : GET요청 발생!");

			model.addAttribute("article", service.getContent(boardNo));
			
		}
	
}
