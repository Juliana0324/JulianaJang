package com.spring.db.jdbc.score.service;

import java.util.List;

import com.spring.db.jdbc.score.model.ScoreVO;

public interface IScoreService {

	//점수 등록 기능
	void insertScore(ScoreVO scores);
	
	//점수 전체 조회 기능
	List<ScoreVO> selectAllScores();
	
	//점수 삭제 기능
	void deleteScore(int stuNum);
	
	//점수 개별 조회 기능
	ScoreVO selectOne(int stuNum);
	
}
