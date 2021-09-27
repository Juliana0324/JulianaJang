package study.spring.myapp.service;

import java.util.List;

import study.spring.myapp.model.ScoreVO;

public interface IScoreService {
	
	//���� ��ϱ��
	void insertScore(ScoreVO scores);
	
	//���� ��ü��ȸ���
	List<ScoreVO> selectAllScores();
	
	//�����������
	void deleteScore(int stuNum);
	
	//���� �������
	ScoreVO selectOne(int stuNum);
	
}
