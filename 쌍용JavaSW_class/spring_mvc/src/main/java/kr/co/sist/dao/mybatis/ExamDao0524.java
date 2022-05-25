package kr.co.sist.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;

/**
 * @author user
 *
 */
@Component
public class ExamDao0524 {
	public List<String> scmr(int deptno) throws PersistenceException{
		List<String> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("scmr", deptno);
		
		if(ss!=null) ss.close();
		
		return list;
	}
	
	
	public EmpDomain mcsr(int empno) throws PersistenceException{
		EmpDomain ed = null;
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		ed = ss.selectOne("mcsr", empno);
		
		if(ss!=null) {ss.close();}
		
		return ed;
	}
	
	public List<EmpDomain> mcmr(int deptno) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("mcmr", deptno);
		
		if(ss!=null) ss.close();
		
		return list;
	}

	public List<EmpDomain> lessThan(int sal) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("lessThan", sal);
		
		if(ss!=null) ss.close();
		
		return list;
	}
	
	
	
}
