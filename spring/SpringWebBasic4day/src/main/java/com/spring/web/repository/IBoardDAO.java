package study.spring.myapp.repository;

import java.util.List;

import study.spring.myapp.model.BoardVO;

public interface IBoardDAO {
	
	//게시글 목록 불러오기
	List<BoardVO> getArticles();
	
	//게시글 등록
	void insertArticle(BoardVO article);
	
	//게시글 삭제
	void deleteArticle(int index);
	
	//게시글 내용보기
	BoardVO getContent(int index);
	
	//게시글 수정
	void modifyArticle(BoardVO article, int index);
	
}
