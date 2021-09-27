package study.spring.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.myapp.model.BoardVO;
import study.spring.myapp.repository.IBoardDAO;

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
		article.toString();
		dao.insertArticle(article);
	}

	@Override
	public void deleteArticle(int boardNo) {
		int index = boardNo - 1;
		dao.deleteArticle(index);
	}

	@Override
	public BoardVO getContent(int boardNo) {
		BoardVO contents = dao.getContent(boardNo - 1);
		return contents;
	}

	@Override
	public void modifyArticle(BoardVO article, int boardNo) {
		dao.modifyArticle(article, boardNo-1);
	}


}
