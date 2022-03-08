package day0308;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;

/**
 * AutoCommit�� ���� ������ ��
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
			System.out.println(cnt+"�� �߰�");
			
			if(cnt==1) {
				conn.commit();
			}
		}finally {
			//close�� �ϸ� �ڵ����� commit��
//			dc.close(null, pstmt, conn);
		}
	}
	
	public static void main(String[] args) {
		ClobVO cvo = new ClobVO();
		cvo.setSubject("������ ������ �Դϴ�.");
		cvo.setContent("������ ���³��Դϴ�.");
		
		TestAutoCommit tac= new TestAutoCommit();
		try {
			tac.insertTestClov(cvo); //�߰� �۾��� 
			System.out.println("�߰� ����.");
		} catch (SQLException e) {
			e.printStackTrace();
		}//end trycatch
		
	}
}
