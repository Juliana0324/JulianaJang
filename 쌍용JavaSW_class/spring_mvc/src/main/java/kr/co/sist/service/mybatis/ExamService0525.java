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
	//@Autowired �ֳ����̼��� ó���ϴ� �� �ش��ϴ� ���� Ÿ���� ��ã�ų� ������ ������ �� �� ���� ��쿡�� 
	//������ �߻��ϸ� ���ø����̼� ������ ����� ���� �ʴ´�.
	
	@Autowired(required = false)
	private ExamDao0525 eDAO; //service���� DAO������ ����
	
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
	 * ��ü ���ڵ� ��
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
	 * ��ȭ�鿡 ������ ������ ��
	 * @return pageScale
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}
	
	
	/**
	 * ��� �Խù��� �����ֱ� ���� ������ ��
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
	 * ���� ��ȣ ���ϱ�
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
	 * �� ��ȣ ���ϱ�
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
