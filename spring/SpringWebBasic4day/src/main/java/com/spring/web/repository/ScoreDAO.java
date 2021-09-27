package study.spring.myapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import study.spring.myapp.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {

	//�л����� ���������� ������ ����Ʈ ����(DB���)
	private List<ScoreVO> scoreList = new ArrayList<>();
	
	@Override
	public void insertScore(ScoreVO scores) {
		System.out.println("Repository param: "+scores);
		scoreList.add(scores);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return scoreList;
	}

	@Override
	public void deleteScore(int stuNum) {
		scoreList.remove(stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {

		return scoreList.get(stuNum);
	}

}
