package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list= service.getArticleList();
		
		System.out.println("URL: /board/list GET -> result: "+ list.size());
		model.addAttribute("articles", list);

		return "board/list";
		
	}
	@GetMapping("/write")
	public void write() {
		System.out.println("URL: /board/write -> GET");
	}
	
	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes ra) {
		//글등록 이후에 목록 요청이 자동으로 들어갈 수 있겠금 처리
		// 글 등록이 완료되었습니다 경고창이 뜰 수 있도록 처리해주세요(글 등록 후에 목록으로 갔을떄만 뜨는 경우)
		System.out.println("URL: /board/write -> POST");
		service.insert(article);
		
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/content/{boardNo}")
	public String content(@PathVariable int boardNo,Model model) {
		System.out.println("URL: /board/content -> GET");
		System.out.println("parameter(글번호): "+boardNo);
		BoardVO vo = service.getArticle(boardNo);
		System.out.println("result data: "+ vo);
		model.addAttribute("article", vo);
		return "board/content";
		
	}
	
	//게시물 삭제 처리 요청
	@PostMapping("/delete")
	public String delete(int boardNo, RedirectAttributes ra) {
		System.out.println("URL: /board/delete?boardNo="+ boardNo + ":POST ");
		service.delete(boardNo);
		ra.addFlashAttribute("msg","delSuccess");
		
		return "redirect:board/list";
	}
	
}
