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
	 * Į�� �ϳ��� ���ϳ� ��ȸ
	 * @param deptno ��ȸ�� �μ���ȣ
	 * @return ��ȸ�� �μ��� dname
	 * @throws PersistenceException
	 */
	public String scsr(int deptno) throws PersistenceException{
		String dname="";
		
		SqlSession ss= MyBatisFramework.getInstance().getMyBatisHandler();
		dname = ss.selectOne("kr.co.sist.dao.scsr",deptno);
		
		return dname;
	}
	
}
