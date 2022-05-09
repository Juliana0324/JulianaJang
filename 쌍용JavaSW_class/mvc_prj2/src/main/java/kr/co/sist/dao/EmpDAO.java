package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.EmpVO;

public class EmpDAO {
	private static EmpDAO eDAO;
	
	
	private EmpDAO() {
		
	}
	
	public static EmpDAO getInstance() {
		//객체가 없거나, 최초호출일 경우
		if(eDAO ==null) {
			eDAO=new EmpDAO();
		}
		return eDAO;
	}
	
	public List<EmpVO> selectEmp( int deptno) throws SQLException{
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		DBCPConnection dbcp=DBCPConnection.getInstance();
		
		try {
			//1. JNDI사용객체 셍성
			//2. DataSource얻기
			//3. Connection 얻기
			conn=dbcp.getConnection();
			
			//4. 쿼리문 생성객체
				//dynamic query: deptno가 0이라면 모든 부서사원정보를 조회, 그렇지 않으면 
				//입력된 부서정보 사원조회
			StringBuilder selectEmp= new StringBuilder();
			selectEmp.append("select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO")
					.append(" from EMP  ");
			if(deptno != 0) {
				selectEmp.append("	where DEPTNO=?	");
			}
			selectEmp.append("	order by EMPNO	");
			
			pstmt=conn.prepareStatement(selectEmp.toString());
			
			//5. 바인드 변수값 설정
			if(deptno!=0) {
				pstmt.setInt(1, deptno);
			}
			//6. 쿼리문 수행후 결과얻기
			rs=pstmt.executeQuery();
			EmpVO eVO= null;
			while(rs.next()) {
				eVO= new EmpVO(rs.getInt("empno"), rs.getInt("mgr"),rs.getInt("sal"),rs.getInt("comm"), rs.getInt("deptno"),
						rs.getString("ename"), rs.getString("job"),  rs.getDate("hiredate"));
				
				list.add(eVO);
				
			}
			
		}finally {
			//연결 끊기
			dbcp.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
}
