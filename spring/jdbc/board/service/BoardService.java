package com.spring.db.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.IBoardDAO;


@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardDAO dao;
	
	@Override
	public List<BoardVO> getArticles() {
		return dao.getArticles();
	}

	@Override
	public void insertArticle(BoardVO article) {
		dao.insertArticle(article);
	}

	@Override
	public void deleteArticle(int index) {
		dao.deleteArticle(index);
	}

	@Override
	public BoardVO getArticle(int index) {
		return dao.getArticle(index);
	}
	
	@Override
	public void updateArticle(BoardVO article) {
		dao.updateArticle(article);
	}
	
	@Override
	public List<BoardVO> searchList(String keyword){
		keyword= "%"+ keyword + "%";
		return dao.searchList(keyword);
		
	}

}

















