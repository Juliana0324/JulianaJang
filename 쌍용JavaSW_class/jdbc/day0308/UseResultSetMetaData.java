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
		ResultSetMetaData rsmd=null;//close를 하는 객체가 아님.
		
		DbConnection dc = DbConnection.getInstance();
			
		try {
			conn=dc.getConn();
			
			//3. 
			StringBuilder selectQuery = new StringBuilder();
			selectQuery.append("SELECT * FROM ").append(tname);
			
			pstmt=conn.prepareStatement(selectQuery.toString());
			
			//5. 
			rs=pstmt.executeQuery();
			
			//실행되는 쿼리의 정보를 얻기 위해 resultsetMetadata사용
			rsmd=rs.getMetaData();
			
			//칼럼의 정보 얻기
			System.out.println(tname+" 테이블 ");
//			System.out.println("칼럼의 갯수 : "+rsmd.getColumnCount());
//			System.out.println("칼럼의 이름: ");
//			for(int i=0; i<rsmd.getColumnCount();i++) {
//				System.out.print(rsmd.getColumnName(i+1)+" ");				
//			}
//			System.out.println();
//			System.out.println("칼럼의 크기: "+rsmd.getPrecision(1));
//			
			
			//자동화
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
