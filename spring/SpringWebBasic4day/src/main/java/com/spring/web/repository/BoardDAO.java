package study.spring.myapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import study.spring.myapp.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	private List<BoardVO> boardList = new ArrayList<>();
	
	@Override
	public List<BoardVO> getArticles() {
		return boardList;
	}

	@Override
	public void insertArticle(BoardVO article) {
		System.out.println("Repository param: "+article);
		boardList.add(article);
	}

	@Override
	public void deleteArticle(int index) {
		boardList.remove(index);
	}

	@Override
	public BoardVO getContent(int index) {
		return boardList.get(index);
	}

	@Override
	public void modifyArticle(BoardVO article, int index) {
		boardList.set(index, article);
		System.out.println((index+1)+"번 게시글 수정완료!! ");
	}

}
