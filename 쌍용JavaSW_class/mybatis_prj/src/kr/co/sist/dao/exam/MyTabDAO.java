package kr.co.sist.dao.exam;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.sub.UseMyBatis;
import kr.co.sist.vo.MyTabVO;

/**
 * MyBatis Handler�� ����Ͽ� DB �۾� ����.
 * @author user
 */
public class MyTabDAO {

	public int insertMyTab( MyTabVO mtVO) throws PersistenceException{	
		int cnt =0;
		
		//MyBatis Handler ���
		UseMyBatis umb=UseMyBatis.getInstance();
		SqlSession ss=umb.getSqlSession();
		
		//Mapper���� XML�� Parsing�Ͽ� �������� ������ ����� ��´�.
		cnt=ss.insert("insertMyTab", mtVO);
		
		//�������� ������ �� �� �� 1�̶�� 
		if(cnt == 1) {
			ss.commit(); //transaction�� �Ϸ�
		}//end if
		
		//MyBatis Handler �ݱ�
		if( ss != null ) {	ss.close(); 	}//end if
		
		return cnt;		
	}//insertMyTab
	
	public int updateMyTab(MyTabVO mtVO) throws PersistenceException{
		int cnt=0;
		
		//MyBatis Handler ����
		SqlSession ss=null;
		try {
			ss=UseMyBatis.getInstance().getSqlSession();
			cnt=ss.update("kr.co.sist.dao.examMapper.updateMyTab",mtVO);
			if(cnt == 1) {
				ss.commit();
			}//end if
		}finally {
			//MyBatis Handler �ݱ�
			if( ss != null ) { ss.close(); }
		}//end finally
		return cnt;
	}//updateMyTab	
	
	public int deleteMyTab(String id)throws PersistenceException{
		int cnt=0;
		
		//MyBatis Handler���
		SqlSession ss=null;
		try {
		//XML�� parsing�Ͽ� �������� ���� �ϰ� ��� �ޱ�
			ss=UseMyBatis.getInstance().getSqlSession();
			cnt=ss.delete("kr.co.sist.dao.examMapper.deleteMyTab",id);
		
			if(cnt == 1) {
				ss.commit();
			}//end if
			
		//MyBatis Handler�ݱ�
		}finally {
			if(  ss != null ){ ss.close(); }
		}//end finally
		
		return cnt;
	}//deleteMyTab
	
}//class






