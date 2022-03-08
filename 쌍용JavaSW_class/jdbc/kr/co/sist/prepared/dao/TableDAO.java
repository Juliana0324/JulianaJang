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
 * 선택한 테이블에 대한 조회
 * @author user
 *
 */
public class TableDAO {
	/**
	 * 싱글톤으로 변환
	 */
	private static TableDAO tdao;
//	public TableDAO() {
//		
//	}//TableDAO
	
	//클래스 외부에서 객체롸가 되지 않는다
	private TableDAO() {
	}
	
	public static TableDAO getInstance() {
		if(tdao==null) {
			tdao=new TableDAO();
		}
		return tdao;
	}
	
	/**
	 * 테이블명을 받아서 테이블에 대한 모든 사원정보 조회
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

			//preparedStatemet로 테이블명이나 칼럼명을 동적으로 처리할때에는 
			//bind변수를 사용할 수 없습니다.
			//그래서 쿼리문에 직접넣어서 처리한다
			selectTable.append("SELECT empno,ename, sal, comm, deptno FROM ").append(table);
			pstmt= conn.prepareStatement(selectTable.toString());

			//pstmt.setString(1, table);
			//5.쿼리 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			CpEmp5VO ceVO = new CpEmp5VO();
			while(rs.next()) {
				ceVO= new CpEmp5VO(rs.getInt("empno"), rs.getInt("sal"),rs.getInt("comm"),rs.getInt("deptno"),rs.getString("ename"));	
				
				//같은 이름의 VO를 여러개 관리하기위해 LIST추가
				list.add(ceVO);
				
			}
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
}
