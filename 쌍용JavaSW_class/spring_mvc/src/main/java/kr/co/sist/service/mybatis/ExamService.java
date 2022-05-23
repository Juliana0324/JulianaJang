package kr.co.sist.service.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDao;

@Component
public class ExamService {
	//required 
	//@Autowired �ֳ����̼��� ó���ϴ� �� �ش��ϴ� ���� Ÿ���� ��ã�ų� ������ ������ �� �� ���� ��쿡�� 
	//������ �߻��ϸ� ���ø����̼� ������ ����� ���� �ʴ´�.
	
	@Autowired(required = false)
	private ExamDao eDAO;
	
	public String scsr(int deptno) {
		String dname="";
		dname = eDAO.scsr(deptno);

		return dname;
	}
	
}
