package study.spring.myapp.service;

import java.util.List;

import study.spring.myapp.model.ScoreVO;

public interface IScoreService {
	
	//점수 등록기능
	void insertScore(ScoreVO scores);
	
	//점수 전체조회기능
	List<ScoreVO> selectAllScores();
	
	//점수삭제기능
	void deleteScore(int stuNum);
	
	//점수 개별기능
	ScoreVO selectOne(int stuNum);
	
}
