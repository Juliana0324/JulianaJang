package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.vo.CpEmp4VO;

public class TestDAO {
	{
	org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public int insert(CpEmp4VO ceVO) throws IOException {
		int cnt=0;
		//1.������ XML�� ��Ʈ�� ����
		Reader reader=null;
		try {
			reader=Resources.getResourceAsReader("kr/co/sist/dao/SqlMapConfig.xml");
			//2.MyBatis �����ӿ�ũ ����
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			//3.MyBatis Handler ���
			SqlSession ss=ssf.openSession();
			//4.�������� ã�Ƽ� ����( id�� �����ϴٸ� namespace�� ������ �� �ִ�.)
			cnt=ss.insert("kr.co.sist.testMapper.insertCpEmp4",ceVO);
			if(cnt == 1) {
				ss.commit();
			}//end if
			if(ss != null ) { ss.close(); }//end if
		}finally {
			if( reader != null ) { reader.close(); }//end if
		}//end finally
		return cnt;
	}//insert
}//class
