package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.Members;

//���Ⱑ dao�� ������ �ϰ� �ٷ� xml�� ����!
public interface viewRepository {

	//��ü��� �̾��ִ� �޼ҵ�
	public List<Members> allMembers();
	
	//��� ���
	void insertMembers(Members members);
	

	
}
