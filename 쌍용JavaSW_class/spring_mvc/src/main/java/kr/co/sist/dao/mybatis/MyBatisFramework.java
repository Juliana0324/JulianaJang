package kr.co.sist.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Framework�� �����ϰ� MyBatis Handler�� ��ȯ 
 * @author user
 */
public class MyBatisFramework {
	//�̱������� ���
	private static MyBatisFramework mbf;
	private static SqlSessionFactory ssf;
	
	private MyBatisFramework() {
		//log ó��
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public static MyBatisFramework getInstance() {
		if(mbf == null) mbf = new MyBatisFramework();
		return mbf;
	}
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException{
		if(ssf==null) {
			//1. �������� ����
			Reader reader=null;
			try {
				
				reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis/SqlMapConfig.xml");
				ssf = new SqlSessionFactoryBuilder().build(reader);
			}finally {
				//reader ��Ʈ�� �����ֱ�
				if(reader!=null) {reader.close();}
			}
		}
		return ssf;
	}//getSqlSessionFactory
	
	public SqlSession getMyBatisHandler() {
		SqlSession ss = null;
		
		try {
			ss= getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}//getMyBatisHandler
	
	
//	public static void main(String[] args) {
//		//����� 
//		MyBatisFramework mbf = getInstance();
//		SqlSession ss = mbf.getMyBatisHandler();
//		
//		System.out.println(ss);
//	}
}
