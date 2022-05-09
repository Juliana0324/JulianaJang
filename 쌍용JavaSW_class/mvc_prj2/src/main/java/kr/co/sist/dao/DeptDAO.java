package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.DeptVO;

public class DeptDAO {
	public static DeptDAO dDAO;
	private DeptDAO() {
		
	}
	
	public static DeptDAO getInstance() {
		if(dDAO==null) {
			dDAO=new DeptDAO();
		}
		return dDAO;
	}//getInstance
	
	public List<DeptVO> selectAllDept() throws SQLException{
		List<DeptVO> list = new ArrayList<DeptVO>();
		
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
			String sql="select deptno, dname, loc from dept order by deptno desc";
			
			pstmt=conn.prepareStatement(sql);
			
			//5. 바인드 변수값 설정
			//6. 쿼리문 수행후 결과얻기
			rs=pstmt.executeQuery();
			DeptVO dVO=null;
			while(rs.next()) {
				dVO= new DeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				list.add(dVO);
			}
			
		}finally {
			//연결 끊기
			dbcp.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
		DeptDAO dao = new DeptDAO();
		System.out.println(dao.selectAllDept());
	}
}
