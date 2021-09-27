package study.spring.myapp.repository;

import java.util.List;

import study.spring.myapp.model.BoardVO;

public interface IBoardDAO {
	
	//�Խñ� ��� �ҷ�����
	List<BoardVO> getArticles();
	
	//�Խñ� ���
	void insertArticle(BoardVO article);
	
	//�Խñ� ����
	void deleteArticle(int index);
	
	//�Խñ� ���뺸��
	BoardVO getContent(int index);
	
	//�Խñ� ����
	void modifyArticle(BoardVO article, int index);
	
}
