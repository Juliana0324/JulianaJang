package kr.co.sist.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
public class ExamDao {
	
	/**
	 * 칼럼 하나에 행하나 조회
	 * @param deptno 조회할 부서번호
	 * @return 조회된 부서명 dname
	 * @throws PersistenceException
	 */
	public String scsr(int deptno) throws PersistenceException{
		String dname="";
		
		SqlSession ss= MyBatisFramework.getInstance().getMyBatisHandler();
		dname = ss.selectOne("kr.co.sist.dao.scsr",deptno);
		
		return dname;
	}
	
}
