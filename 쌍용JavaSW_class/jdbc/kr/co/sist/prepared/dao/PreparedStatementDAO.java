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
	
	/**
	 * 사원번호에 해당하는 사원의 직무 연봉 보너스를 변경
	 * @param ceVO
	 * @return
	 * @throws SQLException
	 */
	public int updateCpEmp4(CpEmp4VO ceVO) throws SQLException{
		//1.드라이버 로딩
		Connection conn=null;
		PreparedStatement pstmt=null;
		DbConnection dc = DbConnection.getInstance();
		int cnt=0;
		
		try {
			//2. 커넥션얻기
			conn=dc.getConn();
			//3. 쿼리문 넣어 쿼리문 실행해서 얻기
			StringBuilder updateCpEmp=new StringBuilder();
			updateCpEmp
			.append("	UPDATE cp_emp4	")
			.append("	SET job=?, sal=?, comm=? ") //바인드 변수에는 문자열 일지라도 ''를 사용하지 않는다
			.append("	WHERE empno=?	");
			pstmt=conn.prepareStatement(updateCpEmp.toString());
			
			//4.바인드 변수값 할당
			pstmt.setString(1, ceVO.getJob());
			pstmt.setInt(2, ceVO.getSal());
			pstmt.setDouble(3, ceVO.getComm());
			pstmt.setInt(4, ceVO.getEmpno());
			
			//5. 쿼리 수행후 결과 얻기
			cnt= pstmt.executeUpdate();
		}finally {
			//6. 연결끊기
			dc.close(null, pstmt, conn);
		}
		return cnt;	
	}
	
	/**
	 * 사원번호를 입력받아 입력된 회원정보를 삭제
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public int deleteCpEmp4(int empno) throws SQLException{
		int cnt=0;
		//1. 드라이버 로딩
		Connection conn= null;
		PreparedStatement pstmt=null;
		DbConnection dc=DbConnection.getInstance();
		
		try {
			//2.커넥션 연결
			conn= dc.getConn();
			StringBuilder deleteCpEmp= new StringBuilder();
			//3. 쿼리문 얻기
			deleteCpEmp
			.append("DELETE FROM cp_emp4 WHERE empno=?");
			
			pstmt= conn.prepareStatement(deleteCpEmp.toString());
			//4. 바인드 변수 값 할당
			pstmt.setInt(1, empno);
			//5. 쿼리수행후 결과 얻기
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
				//칼럼명을 사용하는경우
//				ceVO.setEname(rs.getString("ename"));
//				ceVO.setSal(rs.getInt("sal"));
//				ceVO.setComm(rs.getDouble("comm"));
//				ceVO.setJob(rs.getString("job"));
				
				//칼럼의 인덱스를 사용(가독성이 좋지않음-권장하지 않음)
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
				
				//같은 이름의 VO를 여러개 관리하기위해 LIST추가
				list.add(ceVO);
			}
			
			
			
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
}
