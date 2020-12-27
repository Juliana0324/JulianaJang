package com.spring.db.jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//글 작성 화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	//작성된 글 등록 처리 요청
	//메서드 이름 -> write() 
	//작성된 글을 리스트에 등록한 후 /board/list.jsp파일로 응답할 수 있도록
	//(글 목록 보여달라는 요청이 다시 들어올 수 있도록) 적절하게 처리를 해 보세요.
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write: POST");
		service.insertArticle(article);
		return "redirect:/board/list";
	}
	
	
	
	
	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
		//DB 대용 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서
		//브라우저에 글 목록을 띄워 주시면 되겠습니다.
		model.addAttribute("articles", service.getArticles());
	}
	
	//글 내용 보기 요청
	@GetMapping("/content")
	public void content(int boardNo, Model model) {
		//DB역할을 하는 리스트에서 글번호에 해당하는 글 객체를 content.jsp로 보내주세요.
		System.out.println("/board/content?boardNo=" + boardNo + ": GET");
		model.addAttribute("article", service.getArticle(boardNo));
//		model.addAttribute("boardNo", boardNo);
	}
	
	//글 수정하기 화면 요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("/board/modify?boardNo=" + boardNo + ": GET");
		model.addAttribute("article", service.getArticle(boardNo));
	}
	
	//글 수정 처리 요청.
	//수정 처리 완료 이후 수정된 글의 상세보기 페이지로 이동시켜 주세요.
	@PostMapping("/modify")
	public String modify(BoardVO article) {
		System.out.println("/board/modify?boardNo=" + article.getBoardNo() + ": POST");
		service.updateArticle(article);
		return "redirect:/board/content?boardNo=" + article.getBoardNo();
	}
	
	//글 삭제 요청
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete?boardNo=" + boardNo + ": GET");
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	//게시글 검색처리 요청
	@GetMapping("/searchList")
	public String searchList(String keyword,Model model) {
		model.addAttribute("articles", service.searchList(keyword));
		return "redirect:/board/list";
	}
}




