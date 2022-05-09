package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DeptDAO;
import kr.co.sist.dao.EmpDAO;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.EmpVO;

/**
 * @author user
 * 업무 로직에 대한 처리, DB사용(연산같은것, 암복호화,,,)
 */
public class EmpService {
	public List<EmpVO> searchEmp(int deptno){
		List<EmpVO> list = null;
		
		EmpDAO eDAO=EmpDAO.getInstance();
		try {
			deptno= chkDeptno(deptno);

			list=eDAO.selectEmp(deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}//searchDept
	
	//연산처리
	private int chkDeptno(int deptno) {
		if(deptno<0) {
			deptno=0;
		}
		return deptno;
	}
}
