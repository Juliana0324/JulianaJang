package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DeptDAO;
import kr.co.sist.vo.DeptVO;

/**
 * @author user
 * 업무 로직에 대한 처리, DB사용(연산같은것, 암복호화,,,)
 */
public class DeptService {
	public List<DeptVO> searchDept(){
		List<DeptVO> list = null;
		
		DeptDAO dDAO=DeptDAO.getInstance();
		try {
			list=dDAO.selectAllDept();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}//searchDept
	
	
}
