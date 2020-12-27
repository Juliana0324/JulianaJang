package com.spring.db.jdbc.board.repository;

import java.util.List;

import com.spring.db.jdbc.board.model.BoardVO;

public interface IBoardDAO {

	//전체 게시글 목록 가져오기
	List<BoardVO> getArticles();

	//게시글 등록
	void insertArticle(BoardVO article);

	//게시글 삭제
	void deleteArticle(int index);

	//게시글 상세 보기
	BoardVO getArticle(int index);

	//게시글 수정
	void updateArticle(BoardVO article);

	List<BoardVO> searchList(String writer);

	
}
