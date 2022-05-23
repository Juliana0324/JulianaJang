package kr.co.sist.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Framework를 생성하고 MyBatis Handler를 반환 
 * @author user
 */
public class MyBatisFramework {
	//싱글톤으로 사용
	private static MyBatisFramework mbf;
	private static SqlSessionFactory ssf;
	
	private MyBatisFramework() {
		//log 처리
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public static MyBatisFramework getInstance() {
		if(mbf == null) mbf = new MyBatisFramework();
		return mbf;
	}
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException{
		if(ssf==null) {
			//1. 설정파일 연결
			Reader reader=null;
			try {
				
				reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis/SqlMapConfig.xml");
				ssf = new SqlSessionFactoryBuilder().build(reader);
			}finally {
				//reader 스트림 끊어주기
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
//		//디버깅 
//		MyBatisFramework mbf = getInstance();
//		SqlSession ss = mbf.getMyBatisHandler();
//		
//		System.out.println(ss);
//	}
}
