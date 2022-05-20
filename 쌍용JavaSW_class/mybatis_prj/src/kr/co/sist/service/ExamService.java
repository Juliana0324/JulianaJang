package kr.co.sist.service;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.dao.exam.MyTabDAO;
import kr.co.sist.vo.MyTabVO;

public class ExamService {
	
	public String addMyTab( MyTabVO mtVO ) {
		String msg=mtVO.getId()+"�߰� ����";
		MyTabDAO mtDAO=new MyTabDAO();
		
		try {
			int cnt=mtDAO.insertMyTab(mtVO);
			if(cnt == 1) {
				msg=mtVO.getId()+"�߰� ����";
			}//end if
		}catch(PersistenceException pe) {
			msg=mtVO.getId()+"�߰� ����";
			pe.printStackTrace();
		}
		
		return msg;
	}//addMyTab
	
	public String modifyMyTab( MyTabVO mtVO ) {
		String msg="���̵� �̸����� Ȯ���ϼ���?";
		MyTabDAO mtDAO=new MyTabDAO();
		
		try {
			int cnt=mtDAO.updateMyTab(mtVO);
			if(cnt == 1) {
				msg=mtVO.getId()+"����Ǿ����ϴ�.";
			}//end if
		}catch(PersistenceException pe) {
			msg=mtVO.getId()+"���� ���� - DB�����߻�";
			pe.printStackTrace();
		}//end catch
		
		return msg;
	}//modifyMyTab
	
	public String removeMyTab( String id) {
		String msg=id+"�� �������� �ʽ��ϴ�.";
		MyTabDAO mtDAO=new MyTabDAO();
		
		try {
			int cnt=mtDAO.deleteMyTab( id );
			if(cnt == 1) {
				msg=id+"�����Ǿ����ϴ�.";
			}//end if
		}catch(PersistenceException pe) {
			msg="���� ���� - DB�����߻�";
			pe.printStackTrace();
		}//end catch
		
		return msg;
	}//modifyMyTab
	
}//class
