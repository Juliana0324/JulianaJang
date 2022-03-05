package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton Pattern�� ������ Ŭ����
 * Connection���, ����
 * @author user
 *
 */
public class DbConnection {
	private static DbConnection dc;

	private DbConnection() {
		
	}//Ŭ���� �ܺο��� ��üȭ �Ǵ°��� ���´�
	
	/**
	 * DBconnection ��ü�� ��ȯ�ϴ���
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
