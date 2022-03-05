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
			
			//4.���ε庯���� ������
			pstmt.setString(1, ceVO.getEname());//ó�� ���ε� ������ ���ڿ��� �����ȣ �ִ´�
			pstmt.setString(2, ceVO.getJob());//���ε� ������ ���ڿ��� �� �ִ´�
			pstmt.setInt(3, ceVO.getSal());//���ε� ������ ������ �����ִ´�
			pstmt.setDouble(4, ceVO.getComm());//ó�� ���ε� ������ double�� ���ʽ��ִ´�

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
