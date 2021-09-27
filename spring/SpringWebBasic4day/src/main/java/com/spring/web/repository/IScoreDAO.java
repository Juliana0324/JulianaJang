package study.spring.myapp.repository;

import java.util.List;

import study.spring.myapp.model.ScoreVO;

public interface IScoreDAO {
	//���� ��ϱ��
		void insertScore(ScoreVO scores);

		//���� ��ü ��ȸ ���
		List<ScoreVO> selectAllScores();

		//���� �������
		void deleteScore(int stuNum);

		//���� ���� ��ȸ ���
		ScoreVO selectOne(int stuNum);

}
