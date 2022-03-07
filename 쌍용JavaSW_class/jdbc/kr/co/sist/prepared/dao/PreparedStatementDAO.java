package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	/**
	 * �����ȣ�� �ش��ϴ� ����� ���� ���� ���ʽ��� ����
	 * @param ceVO
	 * @return
	 * @throws SQLException
	 */
	public int updateCpEmp4(CpEmp4VO ceVO) throws SQLException{
		//1.����̹� �ε�
		Connection conn=null;
		PreparedStatement pstmt=null;
		DbConnection dc = DbConnection.getInstance();
		int cnt=0;
		
		try {
			//2. Ŀ�ؼǾ��
			conn=dc.getConn();
			//3. ������ �־� ������ �����ؼ� ���
			StringBuilder updateCpEmp=new StringBuilder();
			updateCpEmp
			.append("	UPDATE cp_emp4	")
			.append("	SET job=?, sal=?, comm=? ") //���ε� �������� ���ڿ� ������ ''�� ������� �ʴ´�
			.append("	WHERE empno=?	");
			pstmt=conn.prepareStatement(updateCpEmp.toString());
			
			//4.���ε� ������ �Ҵ�
			pstmt.setString(1, ceVO.getJob());
			pstmt.setInt(2, ceVO.getSal());
			pstmt.setDouble(3, ceVO.getComm());
			pstmt.setInt(4, ceVO.getEmpno());
			
			//5. ���� ������ ��� ���
			cnt= pstmt.executeUpdate();
		}finally {
			//6. �������
			dc.close(null, pstmt, conn);
		}
		return cnt;	
	}
	
	/**
	 * �����ȣ�� �Է¹޾� �Էµ� ȸ�������� ����
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public int deleteCpEmp4(int empno) throws SQLException{
		int cnt=0;
		//1. ����̹� �ε�
		Connection conn= null;
		PreparedStatement pstmt=null;
		DbConnection dc=DbConnection.getInstance();
		
		try {
			//2.Ŀ�ؼ� ����
			conn= dc.getConn();
			StringBuilder deleteCpEmp= new StringBuilder();
			//3. ������ ���
			deleteCpEmp
			.append("DELETE FROM cp_emp4 WHERE empno=?");
			
			pstmt= conn.prepareStatement(deleteCpEmp.toString());
			//4. ���ε� ���� �� �Ҵ�
			pstmt.setInt(1, empno);
			//5. ���������� ��� ���
			cnt=pstmt.executeUpdate();
		}finally {
			dc.close(null, pstmt, conn);
		}
		
		return cnt;	
	}
	
	public CpEmp4VO selectOneCpEmp4(int empno) throws SQLException{
		CpEmp4VO ceVO=null;
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		DbConnection dc= DbConnection.getInstance();
		
		try {
			conn=dc.getConn();
			StringBuilder selectOne=new StringBuilder();
			selectOne.append("SELECT ename, sal, comm, job FROM cp_emp4 WHERE empno=?");
			
			pstmt=conn.prepareStatement(selectOne.toString());
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();				
			if(rs.next()) {
				ceVO=new CpEmp4VO();
				//Į������ ����ϴ°��
//				ceVO.setEname(rs.getString("ename"));
//				ceVO.setSal(rs.getInt("sal"));
//				ceVO.setComm(rs.getDouble("comm"));
//				ceVO.setJob(rs.getString("job"));
				
				//Į���� �ε����� ���(�������� ��������-�������� ����)
				ceVO.setEname(rs.getString(1));
				ceVO.setSal(rs.getInt(2));
				ceVO.setComm(rs.getDouble(3));
				ceVO.setJob(rs.getString(4));
			}
		}finally {
			dc.close(rs, pstmt, conn);
		}
		
		return ceVO;
	}
	
	public List<CpEmp4VO> selectAllCpEmp4() throws SQLException{
		List<CpEmp4VO> list= new ArrayList<CpEmp4VO>();
		CpEmp4VO ceVO=null;
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		DbConnection dc= DbConnection.getInstance();
		
		try {
			conn=dc.getConn();
			StringBuilder selectAll=new StringBuilder();
			selectAll.append("SELECT empno, ename, job, sal, comm, hiredate FROM cp_emp4");
			pstmt= conn.prepareStatement(selectAll.toString());
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ceVO= new CpEmp4VO();	
				ceVO.setEmpno(rs.getInt("empno"));
				ceVO.setEname(rs.getString("ename"));
				ceVO.setJob(rs.getString("job"));
				ceVO.setSal(rs.getInt("sal"));
				ceVO.setComm(rs.getDouble("comm"));
				ceVO.setHiredate(rs.getDate("hiredate"));
				
				//���� �̸��� VO�� ������ �����ϱ����� LIST�߰�
				list.add(ceVO);
			}
			
			
			
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
}
