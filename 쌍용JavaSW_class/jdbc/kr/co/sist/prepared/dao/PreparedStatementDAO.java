package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.prepared.vo.CpEmp4VO;

public class PreparedStatementDAO {
	public PreparedStatementDAO(){
		
	}
	
	public void insertCpEmp4(CpEmp4VO ceVO) throws SQLException{
		//1.
		Connection conn=null;
		PreparedStatement pstmt=null;
		DbConnection dc = DbConnection.getInstance();
		
		try {
			conn= dc.getConn();
			String insertCpEmp="insert into cp_emp4(empno, ename, job,sal, comm) values(seq_cp_emp4.nextval,?,?,?,?)";
			pstmt=conn.prepareStatement(insertCpEmp);
			
			//4.바인드변수에 값설정
			pstmt.setString(1, ceVO.getEname());//처음 바인드 변수에 문자열로 사원번호 넣는다
			pstmt.setString(2, ceVO.getJob());//바인드 변수에 문자열로 일 넣는다
			pstmt.setInt(3, ceVO.getSal());//바인드 변수에 정수로 연봉넣는다
			pstmt.setDouble(4, ceVO.getComm());//처음 바인드 변수에 double로 보너스넣는다

			pstmt.executeUpdate();
		}finally {
			dc.close(null, pstmt, conn);
		}
		
	}
	
	public int updateCpEmp4(CpEmp4VO ceVO) throws SQLException{
		int cnt=0;
		return cnt;	
	}
	public int deleteCpEmp4(int empno) throws SQLException{
		int cnt=0;
		return cnt;	
	}
	
	public CpEmp4VO selectOneCpEmp4(int empno) throws SQLException{
		CpEmp4VO ceVO=null;
		return ceVO;
	}
	
	public List<CpEmp4VO> selectAllCpEmp4() throws SQLException{
		List<CpEmp4VO> list= new ArrayList<CpEmp4VO>();
		return list;
	}
	
	
}
