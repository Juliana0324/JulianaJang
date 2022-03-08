package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.prepared.vo.CpEmp4VO;
import kr.co.sist.prepared.vo.CpEmp5VO;

/**
 * ������ ���̺� ���� ��ȸ
 * @author user
 *
 */
public class TableDAO {
	/**
	 * �̱������� ��ȯ
	 */
	private static TableDAO tdao;
//	public TableDAO() {
//		
//	}//TableDAO
	
	//Ŭ���� �ܺο��� ��ü�ְ� ���� �ʴ´�
	private TableDAO() {
	}
	
	public static TableDAO getInstance() {
		if(tdao==null) {
			tdao=new TableDAO();
		}
		return tdao;
	}
	
	/**
	 * ���̺���� �޾Ƽ� ���̺� ���� ��� ������� ��ȸ
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp5VO> selectTable(String table) throws SQLException{
		List<CpEmp5VO> list = new ArrayList<CpEmp5VO>();
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		DbConnection dc = DbConnection.getInstance();
		try {
			conn=dc.getConn();
			StringBuilder selectTable=new StringBuilder();

			//preparedStatemet�� ���̺���̳� Į������ �������� ó���Ҷ����� 
			//bind������ ����� �� �����ϴ�.
			//�׷��� �������� �����־ ó���Ѵ�
			selectTable.append("SELECT empno,ename, sal, comm, deptno FROM ").append(table);
			pstmt= conn.prepareStatement(selectTable.toString());

			//pstmt.setString(1, table);
			//5.���� ���� �� ��� ���
			rs=pstmt.executeQuery();
			
			CpEmp5VO ceVO = new CpEmp5VO();
			while(rs.next()) {
				ceVO= new CpEmp5VO(rs.getInt("empno"), rs.getInt("sal"),rs.getInt("comm"),rs.getInt("deptno"),rs.getString("ename"));	
				
				//���� �̸��� VO�� ������ �����ϱ����� LIST�߰�
				list.add(ceVO);
				
			}
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
}
