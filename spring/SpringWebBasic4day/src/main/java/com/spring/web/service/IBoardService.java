package study.spring.myapp.service;

import java.util.List;

import study.spring.myapp.model.BoardVO;

public interface IBoardService {
	//�Խñ� ��� �ҷ�����
		List<BoardVO> getArticles();
		
		//�Խñ� ���
		void insertArticle(BoardVO article);
		
		//�Խñ� ����
		void deleteArticle(int boardNo);
		
		//�Խñ� ���뺸��
		BoardVO getContent(int boardNo);
		
		//�Խñ� ����
		void modifyArticle(BoardVO article, int boardNo);
		
}
