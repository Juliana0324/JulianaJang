package day0308;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.prepared.vo.CpEmp5VO;

public class TestTransaction {
	private Connection conn;
	
	public int transaction(CpEmp5VO ceVO) throws SQLException{
		int rowCnt=0;
		//1.
		DbConnection dc = DbConnection.getInstance();
		conn=dc.getConn();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		//2.
		//3.
		String insertTransaction1="INSERT INTO test_transaction1 values(?,?)";
		pstmt=conn.prepareStatement(insertTransaction1);
		
		//4.
		pstmt.setInt(1, ceVO.getEmpno());
		pstmt.setString(2, ceVO.getEname());
		
		String insertTransaction2="INSERT INTO test_transaction2 values(?,?)";
		pstmt2=conn.prepareStatement(insertTransaction1);
		
		//4.
		pstmt2.setInt(1, ceVO.getEmpno());
		pstmt2.setString(2, ceVO.getEname());
		
		int cnt1= pstmt.executeUpdate();
		int cnt2=pstmt2.executeUpdate();
		
		return rowCnt;
	}
	
	public void useTransaction() throws SQLException {
		CpEmp5VO ceVO = new CpEmp5VO();
		ceVO.setEmpno(1);
		ceVO.setEname("비정상적비정상");
		
		try {
			int totalCnt = transaction(ceVO);
			if(totalCnt==2) { //insert두번실행
				System.out.println("추가되었습니다.");
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("취소되었습니다.");
			conn.rollback();
			e.printStackTrace();
		}finally {
			if(conn!=null) {conn.close();}
		}
		
	}
	
	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		try {
			tt.useTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
