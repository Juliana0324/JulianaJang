package day0308;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;

public class UseResultSetMetaData {
	public String useResultSetMetaData(String tname) throws SQLException {
		StringBuilder output=new StringBuilder();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;//close�� �ϴ� ��ü�� �ƴ�.
		
		DbConnection dc = DbConnection.getInstance();
			
		try {
			conn=dc.getConn();
			
			//3. 
			StringBuilder selectQuery = new StringBuilder();
			selectQuery.append("SELECT * FROM ").append(tname);
			
			pstmt=conn.prepareStatement(selectQuery.toString());
			
			//5. 
			rs=pstmt.executeQuery();
			
			//����Ǵ� ������ ������ ��� ���� resultsetMetadata���
			rsmd=rs.getMetaData();
			
			//Į���� ���� ���
			System.out.println(tname+" ���̺� ");
//			System.out.println("Į���� ���� : "+rsmd.getColumnCount());
//			System.out.println("Į���� �̸�: ");
//			for(int i=0; i<rsmd.getColumnCount();i++) {
//				System.out.print(rsmd.getColumnName(i+1)+" ");				
//			}
//			System.out.println();
//			System.out.println("Į���� ũ��: "+rsmd.getPrecision(1));
//			
			
			//�ڵ�ȭ
			for(int i=1; i<=rsmd.getColumnCount();i++) {
				output.append(rsmd.getColumnName(i)).append(" ")
				.append(rsmd.getColumnTypeName(i)).append(" ")
				.append(rsmd.getPrecision(i)).append(" ")
				.append(rsmd.isNullable(i)==0?"NOT NULL":"").append("\n");
			}
		}finally {
			dc.close(rs, pstmt, conn);
			
			
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		UseResultSetMetaData ursmd= new UseResultSetMetaData();
		String tname = "EMP";
		try {
			System.out.println(ursmd.useResultSetMetaData(tname));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
