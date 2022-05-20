package kr.co.sist.dao.exam;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.sub.UseMyBatis;
import kr.co.sist.vo.MyTabVO;

/**
 * MyBatis Handler를 사용하여 DB 작업 수행.
 * @author user
 */
public class MyTabDAO {

	public int insertMyTab( MyTabVO mtVO) throws PersistenceException{	
		int cnt =0;
		
		//MyBatis Handler 얻기
		UseMyBatis umb=UseMyBatis.getInstance();
		SqlSession ss=umb.getSqlSession();
		
		//Mapper에서 XML을 Parsing하여 쿼리문을 실행한 결과를 얻는다.
		cnt=ss.insert("insertMyTab", mtVO);
		
		//쿼리문을 실행한 행 수 가 1이라면 
		if(cnt == 1) {
			ss.commit(); //transaction을 완료
		}//end if
		
		//MyBatis Handler 닫기
		if( ss != null ) {	ss.close(); 	}//end if
		
		return cnt;		
	}//insertMyTab
	
	public int updateMyTab(MyTabVO mtVO) throws PersistenceException{
		int cnt=0;
		
		//MyBatis Handler 생성
		SqlSession ss=null;
		try {
			ss=UseMyBatis.getInstance().getSqlSession();
			cnt=ss.update("kr.co.sist.dao.examMapper.updateMyTab",mtVO);
			if(cnt == 1) {
				ss.commit();
			}//end if
		}finally {
			//MyBatis Handler 닫기
			if( ss != null ) { ss.close(); }
		}//end finally
		return cnt;
	}//updateMyTab	
	
	public int deleteMyTab(String id)throws PersistenceException{
		int cnt=0;
		
		//MyBatis Handler얻기
		SqlSession ss=null;
		try {
		//XML을 parsing하여 쿼리문을 수행 하고 결과 받기
			ss=UseMyBatis.getInstance().getSqlSession();
			cnt=ss.delete("kr.co.sist.dao.examMapper.deleteMyTab",id);
		
			if(cnt == 1) {
				ss.commit();
			}//end if
			
		//MyBatis Handler닫기
		}finally {
			if(  ss != null ){ ss.close(); }
		}//end finally
		
		return cnt;
	}//deleteMyTab
	
}//class






