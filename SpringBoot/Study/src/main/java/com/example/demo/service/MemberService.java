package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.viewRepository;
import com.example.demo.vo.Members;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	
	private viewRepository dao;
	
	@Transactional
	public void insertMember(Members member) {
		dao.insertMembers(member);
		
	}
	
}
