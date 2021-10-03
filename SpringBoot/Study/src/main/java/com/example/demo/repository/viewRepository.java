package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.Members;

//여기가 dao의 역할을 하고 바로 xml로 직행!
public interface viewRepository {

	//전체멤버 뽑아주는 메소드
	public List<Members> allMembers();
	
	//멤버 등록
	void insertMembers(Members members);
	

	
}
