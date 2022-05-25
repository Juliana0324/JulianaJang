package kr.co.sist.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDao;
import kr.co.sist.dao.mybatis.ExamDao0524;
import kr.co.sist.domain.mybatis.EmpDomain;

@Component
public class ExamService0524 {
	//required 
	//@Autowired �ֳ����̼��� ó���ϴ� �� �ش��ϴ� ���� Ÿ���� ��ã�ų� ������ ������ �� �� ���� ��쿡�� 
	//������ �߻��ϸ� ���ø����̼� ������ ����� ���� �ʴ´�.
	
	@Autowired(required = false)
	private ExamDao0524 eDAO;
	
	public List<String> scmr(int deptno) {
		List<String> list = null;
		try {
			list = eDAO.scmr(deptno);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	public EmpDomain mcsr(int empno) {
		EmpDomain ed = null;
		
		try {
			ed = eDAO.mcsr(empno);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return ed;
	}
	
	public List<EmpDomain> mcmr(int deptno) {
		List<EmpDomain> list = null;
		try {
			list = eDAO.mcmr(deptno);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}

	public List<EmpDomain> lessThan(int sal) {
		List<EmpDomain> list = null;
		try {
			list = eDAO.lessThan(sal);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
}
