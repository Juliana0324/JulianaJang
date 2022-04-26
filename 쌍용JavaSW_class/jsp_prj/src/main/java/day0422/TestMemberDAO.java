package day0422;

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


public class TestMemberDAO {
	
private static TestMemberDAO fDAO;
	
	private TestMemberDAO() {
		
	}
	public static TestMemberDAO getInstance() {
		if(fDAO==null) {
			fDAO=new TestMemberDAO();
		
		}
		return fDAO;
	}
	private Connection getConnection() throws SQLException {
		Connection conn=null;
		//1. JNDI사용객체 생성
		Context ctx;
		try {
			ctx = new InitialContext();
			//2. DBCP찾기
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/dbcp");
			conn=ds.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	public boolean selectMember(String ckid) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		boolean flag=false;
		try {
			conn= getConnection();
			String selectMember="SELECT id FROM test_member WHERE id=?";
			pstmt=conn.prepareStatement(selectMember);
			pstmt.setString(1, ckid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				flag=true;
			}
			
		}finally {
			dbClose(rs,pstmt, conn);
		}
			
		return flag;
	}
	

	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
	
}
