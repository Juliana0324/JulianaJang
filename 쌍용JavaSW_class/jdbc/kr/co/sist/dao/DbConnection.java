package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton Pattern을 도입한 클래스
 * Connection얻기, 끊기
 * @author user
 *
 */
public class DbConnection {
	private static DbConnection dc;

	private DbConnection() {
		
	}//클래스 외부에서 객체화 되는것을 막는다
	
	/**
	 * DBconnection 객체를 반환하는일
	 * @return
	 */
	public static DbConnection getInstance() {
		if(dc==null) {
			dc=new DbConnection();
		}
		return dc;
	}
	
	public Connection getConn() throws SQLException{
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="tiger";
		con= DriverManager.getConnection(url, id,pw);
		
		return con;
	}
	
	public Statement getStatement() throws SQLException {
		Statement stmt=null;
		stmt=getConn().createStatement();
		return stmt;
	}
	
	public void close(ResultSet rs, Statement stmt, Connection con) throws SQLException{
		if(rs!=null) {rs.close();}
		if(stmt!=null) {stmt.close();}
		if(con!=null) {con.close();}
	}
	
}
