package kr.co.sist.dao.sub;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {

	private static UseMyBatis umb;
	private static SqlSessionFactory ssf;
	
	private UseMyBatis() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//UseMyBatis
	
	public static UseMyBatis getInstance() {
		if(umb == null) {
			umb=new UseMyBatis();
		}//end if
		return umb;
	}//getInstance
	
	private  SqlSessionFactory getSessionFactory() throws IOException {
		if(ssf== null) {
			Reader reader=null;
			try {
				//1.스트림을 사용해서 설정파일 연결.
				reader=Resources.getResourceAsReader("kr/co/sist/dao/sub/SqlMapConfig.xml");
				//2. 스트림을 입력하여 MyBatis Framework생성.
				ssf=new SqlSessionFactoryBuilder().build( reader );
			}finally {
				if( reader != null ) { reader.close(); }//end if
			}//end finally
		}//end if
		return ssf;
	}//getSessionFactory
	
	/**
	 * Handler 얻기
	 * @return
	 */
	public SqlSession getSqlSession() {
		SqlSession ss=null;
		try {
			ss=getSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		return ss;
	}//getSqlSession
	
}//class
