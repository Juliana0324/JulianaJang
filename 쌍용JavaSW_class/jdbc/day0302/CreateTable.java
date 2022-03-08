package day0302;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author user
 *
 */
public class CreateTable {

	public CreateTable() throws SQLException{
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		Statement stmt =null;
		try {
			//2. Connection얻기
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pw="tiger";
			
			conn=DriverManager.getConnection(url,id,pw);
			
			
			//3.쿼리문 생성 객체얻기
			stmt=conn.createStatement();
			
			//4.쿼리 수행후 결과 얻기
//			String createQuery="CREATE TABLE test(num number, name varchar2(30), input_date date default sysdate)";
			String createQuery="DROP TABLE test";
			boolean flag= stmt.execute(createQuery);
			//쿼리의 실행이 정상적이라면 조회된 값이없어서 false 리턴
			//쿼리 실행 실패라면 예외리턴			
//			if(flag) {
			System.out.println(flag);
			System.out.println("테이블 생성 성공"+stmt.getQueryTimeout());
//			}
		}finally {
			//5. 연결끊기
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}
	}
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException se) {
			System.err.println("테이블 생성 실패");
			se.printStackTrace();
		}
	}

}
