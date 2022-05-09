package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBCPConnection {
	
private static DBCPConnection fDAO;
	
	private DBCPConnection() {
		
	}
	public static DBCPConnection getInstance() {
		if(fDAO==null) {
			fDAO=new DBCPConnection();
		
		}
		return fDAO;
	}
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		//1. JNDI사용객체
		Context ctx;
		try {
			ctx = new InitialContext();
			//2. DBCP를 찾아 DataSource얻기
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/mvc2");
			conn=ds.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	

	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
	
}
