package kr.co.sist.statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import kr.co.sist.statement.vo.CpEmp4InsertVO;
import kr.co.sist.statement.vo.CpEmp4SelectAllVO;
import kr.co.sist.statement.vo.CpEmp4SelectOneVO;
import kr.co.sist.statement.vo.CpEmp4UpdateVO;

/**
 * DAO: DB�۾��� ���ؼ� �����Ѵ�
 * method���� ������ ���� �ִ�
 * @author user
 *
 */
public class StatementDAO {
	public StatementDAO(){		
	}
	
	/**
	 * DBMS�� ������ ��ü�� ��ȯ�ϴ���
	 * @return connection
	 * @throws SQLException
	 */
	private Connection getDbConnection() throws SQLException{
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="tiger";
		conn= DriverManager.getConnection(url, id,pw);
		
		return conn;
	}
	
	public void insertCpEmp4(CpEmp4InsertVO insertVO) throws SQLException{
		System.out.println("��� �߰�");
		
		Connection conn=null;
		Statement stmt=null;
		try {
			//1. ����̹� �ε�
			//2. ��Ŀ�ؼ� ���
			conn=getDbConnection();
			
			//3. ������ ������ü ���
			stmt= conn.createStatement();
					
			StringBuilder insertCpEmp=new StringBuilder();
			insertCpEmp.append("INSERT INTO cp_emp4(empno, ename, job,sal,comm) VALUES(")
			.append(insertVO.getEmpno())
			.append(",'")
			.append(insertVO.getEname())
			.append("', '").append(insertVO.getJob()).append("', ").append(insertVO.getSal())
			.append(", ").append(insertVO.getComm()).append(")");
						
			System.out.println(insertCpEmp);

			int cnt=stmt.executeUpdate(insertCpEmp.toString());
			System.out.println(cnt+"�� �Է¼���");
			
		}finally {
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		
	}
	/**
	 * �����������
	 * @param updateVO
	 * @return
	 * @throws SQLException
	 */
	public int updateCpEmp4(CpEmp4UpdateVO updateVO) throws SQLException{
		System.out.println("��� ����");
		int rowCnt=0;
		Connection conn=null;
		Statement stmt=null;
		try {
			//1. ����̹��ε�
			conn=getDbConnection();
			stmt= conn.createStatement();
			
			StringBuilder updateCpEmp = new StringBuilder();
			updateCpEmp
			.append("UPDATE	cp_emp4 ")
			.append("SET job='").append(updateVO.getJob()).append("', ")
			.append("sal=").append(updateVO.getSal()).append(", ")
			.append("comm=").append(updateVO.getComm())
			.append(" WHERE empno=").append(updateVO.getEmpno());
			System.out.println(updateCpEmp);
			
			rowCnt=stmt.executeUpdate(updateCpEmp.toString());

			System.out.println(rowCnt+"�� ��������");
		}finally{
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		return rowCnt;
	}
	
	public int deleteCpEm4(int empno) throws SQLException{
		System.out.println("��� ����");
		int rowCnt=0;
		Connection conn=null;
		Statement stmt=null;
		try {
			//1. ����̹��ε�
			conn=getDbConnection();
			//2.Ŀ�ؼ� ���
			stmt= conn.createStatement();
			//3. ������ ������ü ���
			StringBuilder deleteCpEmp = new StringBuilder();
			deleteCpEmp
			.append("DELETE	FROM cp_emp4 ")
			.append(" WHERE empno=").append(empno);

			System.out.println(deleteCpEmp);
			//4. ������ ������ ������
			rowCnt=stmt.executeUpdate(deleteCpEmp.toString());

			System.out.println(rowCnt+"�� ��������");
		}finally{
			//5.�������
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		return rowCnt;
	}
	public CpEmp4SelectOneVO selectCpEmp4(int empno) throws SQLException{
		System.out.println("��� ��ȸ");
		CpEmp4SelectOneVO selectOneVO=null;
		
		Connection conn= null;
		Statement stmt= null;
		ResultSet rs=null;
		
		try {
			conn= getDbConnection();
			stmt=conn.createStatement();
			
			StringBuilder selectOneCpEmp = new StringBuilder();
			selectOneCpEmp.append("SELECT ename,job,sal,comm FROM cp_emp4 WHERE empno=").append(empno);
			rs = stmt.executeQuery(selectOneCpEmp.toString()); //rs=>�� Ŀ���� ������� ��
			
			if(rs.next()) {
				//�����ȣ�� �˻��� ���ڵ尡 ����
				selectOneVO = new CpEmp4SelectOneVO();
				//cursor�� �����ϴ� ���ڵ尡 ���Į���� ���� �����ͼ�
				selectOneVO.setEname(rs.getString("ename"));
				selectOneVO.setJob(rs.getString("job"));
				selectOneVO.setSal(rs.getInt("sal"));
				selectOneVO.setComm(rs.getDouble("comm"));
			}
			
			
		} finally {
			if(rs!=null) {rs.close();}
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		return selectOneVO;
	}
	
	public List<CpEmp4SelectAllVO> selectCpEmp4() throws SQLException{
		System.out.println("��� ��ü ��ȸ");
		List<CpEmp4SelectAllVO> list=new ArrayList<CpEmp4SelectAllVO>();
		ResultSet rs=null;
		Connection conn= null;
		Statement stmt=null;
		
		try {
			conn=getDbConnection();
			stmt= conn.createStatement();
			StringBuilder selectCpEmp = new StringBuilder();
			selectCpEmp.append("SELECT empno, ename, job,sal, comm, hiredate, to_char(hiredate,'yyyy-mm-dd') hiredate2")
					.append(" FROM cp_emp4 ORDER BY empno");
			
			rs=stmt.executeQuery(selectCpEmp.toString());
			CpEmp4SelectAllVO selectAllVO=null;
			
			while(rs.next()) {
				selectAllVO= new CpEmp4SelectAllVO();
				selectAllVO.setEmpno(rs.getInt("empno"));
				selectAllVO.setEname(rs.getString("ename"));
				selectAllVO.setJob(rs.getString("job"));
				selectAllVO.setSal(rs.getInt("sal"));
				selectAllVO.setComm(rs.getDouble("comm"));
				selectAllVO.setHiredate(rs.getDate("hiredate"));
				selectAllVO.setHiredate2(rs.getString("hiredate2")); //date-> to_char() -> string
				
				//���ڵ� �ϳ��� ���� VO�� list�� �߰�
				list.add(selectAllVO);
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
		StatementDAO sd= new StatementDAO();
		System.out.println(sd.selectCpEmp4());
	}
	
}
