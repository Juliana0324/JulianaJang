package kr.co.sist.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.ModelDomain;
import kr.co.sist.vo.BoardVO;

/**
 * @author user
 *
 */
@Component
public class ExamDao0525 {
	
	public List<EmpDomain> greaterThan(int sal) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("kr.co.sist.dao.exam3.greaterThan", sal);
		
		if(ss!=null) ss.close();
		
		return list;
	}

	public List<ModelDomain> like(String option) throws PersistenceException{
		List<ModelDomain> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("kr.co.sist.dao.exam3.like", option);
		
		if(ss!=null) ss.close();
		
		return list;
	}

	public int selectTotalCnt() {
		int totalCnt =0; 
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		totalCnt= ss.selectOne("kr.co.sist.dao.exam3.selectCarCnt"); //mapper에 ParameterType이 없음으로 매개변수가 ㅇ존재하지 않는다
		if(ss!=null) ss.close();
		return totalCnt;
	}
	
	public List<ModelDomain> subquery(BoardVO bvo) throws PersistenceException{
		List<ModelDomain> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("kr.co.sist.dao.exam3.subquery", bvo);
		
		if(ss!=null) ss.close();
		
		return list;
	}

	public List<EmpDomain> union() throws PersistenceException{
		List<EmpDomain> list = null;
		
		//Mybatis Handler 얻기
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("kr.co.sist.dao.exam3.union");
		
		if(ss!=null) ss.close();
		
		return list;
	}
	
	
	
}
