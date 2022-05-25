package kr.co.sist.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDao;
import kr.co.sist.dao.mybatis.ExamDao0524;
import kr.co.sist.dao.mybatis.ExamDao0525;
import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.ModelDomain;
import kr.co.sist.vo.BoardVO;

@Component
public class ExamService0525 {
	//required 
	//@Autowired 애노테이션을 처리하던 중 해당하는 빈의 타입을 못찾거나 의존성 주입을 할 수 없는 경우에는 
	//에러가 발생하며 어플리케이션 구동이 제대로 되지 않는다.
	
	@Autowired(required = false)
	private ExamDao0525 eDAO; //service에서 DAO의존성 주입
	
	public List<EmpDomain> greaterThan(int sal) {
		List<EmpDomain> list = null;
		try {
			list = eDAO.greaterThan(sal);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}

	public List<ModelDomain> like(String option) {
		List<ModelDomain> list = null;
		try {
			list = eDAO.like(option);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}

	/**
	 * 전체 레코드 수
	 * @return totalCnt
	 */
	public int searchTotalCnt() {
		int totalCnt=0;
		try {
			totalCnt= eDAO.selectTotalCnt();
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return totalCnt;
	}
	
	/**
	 * 한화면에 보여줄 페이지 수
	 * @return pageScale
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}
	
	
	/**
	 * 모든 게시물을 보여주기 위한 페이지 수
	 * @param totalCnt
	 * @param pagepageScale
	 * @return
	 */
	public int pageCnt(int totalCnt, int pageScale) {
		int pageCnt=0;
//		
//		pageCnt = totalCnt/pageScale;
//		if(totalCnt%pageScale !=0) pageCnt++;
		
		pageCnt = (int)Math.ceil((double)totalCnt/pageScale);
		

		return pageCnt;
	}
	
	
	/**
	 * 시작 번호 구하기
	 * @param currentPage
	 * @param pageScale
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		int startNum = 1;
		startNum = (currentPage * pageScale)-pageScale+1;
		return startNum;
	}

	/**
	 * 끝 번호 구하기
	 * @param currentPage
	 * @param pageScale
	 * @return
	 */
	public int endNum(int startNum, int pageScale, int totalCnt) {
	      int endNum = 0;
	      endNum = startNum + pageScale - 1;
	      
	      if(endNum >totalCnt) {
	    	  endNum = totalCnt;
	      }
	      return endNum;
	   }// endNum
	

	public List<ModelDomain> subquery(BoardVO bvo) {
		List<ModelDomain> list = null;
		try {
			list = eDAO.subquery(bvo);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}

	public List<EmpDomain> union() {
		List<EmpDomain> list = null;
		try {
			list = eDAO.union();
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
}
