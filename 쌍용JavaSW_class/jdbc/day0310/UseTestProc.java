package day0310;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConnection;

public class UseTestProc {
	public UseTestProc() throws SQLException{
		//1. ����̹� �ε�
		Connection conn= null;
		CallableStatement cstmt=null;
		DbConnection dc = DbConnection.getInstance();
		//2. Ŀ�ؼ� ���
		//3. ������ ������ü ���
		try {
			conn= dc.getConn();
			cstmt=conn.prepareCall("{call test_proc(?,?,?,?,?)}");
			
			//4. ���ε� ���� �� ����
			// in parameter(1- �̸�, 2-���� 3- �̸���): procedure�� �ִ°�
			cstmt.setString(1, "����");
			cstmt.setInt(2, 27);
			cstmt.setString(3, "kang@naver.com");
			//out parameter(4-�¾�� 5-������): procedure���� ��°�
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
			//5. ������ ����
			cstmt.execute();
			//6. out parameter�� ����� �� ���
			int birth= cstmt.getInt(4);
			String domain = cstmt.getString(5);
			System.out.println("�¾��: "+birth);
			System.out.println("������ :"+domain);
		}finally {
			dc.close(null, cstmt, conn);
			
		}
	}
	
	public static void main(String[] args) {
		try {
			new UseTestProc();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
