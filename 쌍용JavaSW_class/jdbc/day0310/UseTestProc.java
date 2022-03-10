package day0310;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConnection;

public class UseTestProc {
	public UseTestProc() throws SQLException{
		//1. 드라이버 로딩
		Connection conn= null;
		CallableStatement cstmt=null;
		DbConnection dc = DbConnection.getInstance();
		//2. 커넥션 얻기
		//3. 쿼리문 생성객체 얻기
		try {
			conn= dc.getConn();
			cstmt=conn.prepareCall("{call test_proc(?,?,?,?,?)}");
			
			//4. 바인드 변수 값 설정
			// in parameter(1- 이름, 2-나이 3- 이메일): procedure에 넣는값
			cstmt.setString(1, "강산");
			cstmt.setInt(2, 27);
			cstmt.setString(3, "kang@naver.com");
			//out parameter(4-태어난해 5-도메인): procedure에서 얻는값
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
			//5. 쿼리문 실행
			cstmt.execute();
			//6. out parameter에 저장된 값 얻기
			int birth= cstmt.getInt(4);
			String domain = cstmt.getString(5);
			System.out.println("태어난해: "+birth);
			System.out.println("도메인 :"+domain);
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
