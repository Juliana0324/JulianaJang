package day0302;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc connection을 연결한다
 * @author user
 *
 */
public class GetConnection {
	
	public GetConnection() throws SQLException{
		//1. 드라이버 로딩(e:/dev/driver/ojdbc8.jar)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) { //compile exception(Checked exception)
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="tiger";
		System.out.println("드라이버 연결성공");
		
		Connection con=null;
		Statement stmt=null;
		PreparedStatement psmt=null;
		try {
			con= DriverManager.getConnection(url,id,pw);
			System.out.println("db연결 성공"+con);

			//3.쿼리문 생성객체 얻기
			stmt=con.createStatement();
			
			String dname="개발부";
			//4.쿼리문 실헹 후 얻기
			String insertQuery="insert into cp_dept(deptno, dname, loc) values(99, '"+dname+"','서울')";
			int cnt= stmt.executeUpdate(insertQuery);
			System.out.println(insertQuery+"로 "+cnt+"건이 추가되었습니다");
			//psmt=con.prepareStatement(insertQuery);
			
		}
		finally {
			//5.연결끊기
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			new GetConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
