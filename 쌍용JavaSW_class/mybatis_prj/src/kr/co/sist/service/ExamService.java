package kr.co.sist.service;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.dao.exam.MyTabDAO;
import kr.co.sist.vo.MyTabVO;

public class ExamService {
	
	public String addMyTab( MyTabVO mtVO ) {
		String msg=mtVO.getId()+"추가 실패";
		MyTabDAO mtDAO=new MyTabDAO();
		
		try {
			int cnt=mtDAO.insertMyTab(mtVO);
			if(cnt == 1) {
				msg=mtVO.getId()+"추가 성공";
			}//end if
		}catch(PersistenceException pe) {
			msg=mtVO.getId()+"추가 실패";
			pe.printStackTrace();
		}
		
		return msg;
	}//addMyTab
	
	public String modifyMyTab( MyTabVO mtVO ) {
		String msg="아이디나 이메일을 확인하세요?";
		MyTabDAO mtDAO=new MyTabDAO();
		
		try {
			int cnt=mtDAO.updateMyTab(mtVO);
			if(cnt == 1) {
				msg=mtVO.getId()+"변경되었습니다.";
			}//end if
		}catch(PersistenceException pe) {
			msg=mtVO.getId()+"변경 실패 - DB문제발생";
			pe.printStackTrace();
		}//end catch
		
		return msg;
	}//modifyMyTab
	
	public String removeMyTab( String id) {
		String msg=id+"는 존재하지 않습니다.";
		MyTabDAO mtDAO=new MyTabDAO();
		
		try {
			int cnt=mtDAO.deleteMyTab( id );
			if(cnt == 1) {
				msg=id+"삭제되었습니다.";
			}//end if
		}catch(PersistenceException pe) {
			msg="삭제 실패 - DB문제발생";
			pe.printStackTrace();
		}//end catch
		
		return msg;
	}//modifyMyTab
	
}//class
