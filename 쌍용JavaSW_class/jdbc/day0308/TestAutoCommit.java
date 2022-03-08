package day0308;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;

/**
 * AutoCommit에 대한 해제의 예
 * @author user
 *
 */
public class TestAutoCommit {

	public void insertTestClov(ClobVO cVO) throws SQLException{
		Connection conn= null;
		PreparedStatement pstmt = null;
		DbConnection dc = DbConnection.getInstance();
		
		try {
			conn=dc.getConn();
			conn.setAutoCommit(false);
			
			String insert= "insert into test_clob(subject,content) values(?,?)";
			pstmt=conn.prepareStatement(insert);
			
			pstmt.setString(1, cVO.getSubject());
			pstmt.setString(2, cVO.getContent());
			
			int cnt=pstmt.executeUpdate();
			System.out.println(cnt+"건 추가");
			
			if(cnt==1) {
				conn.commit();
			}
		}finally {
			//close를 하면 자동으로 commit됨
//			dc.close(null, pstmt, conn);
		}
	}
	
	public static void main(String[] args) {
		ClobVO cvo = new ClobVO();
		cvo.setSubject("오늘은 수요일 입니다.");
		cvo.setContent("내일은 쉬는날입니다.");
		
		TestAutoCommit tac= new TestAutoCommit();
		try {
			tac.insertTestClov(cvo); //추가 작업후 
			System.out.println("추가 성공.");
		} catch (SQLException e) {
			e.printStackTrace();
		}//end trycatch
		
	}
}
