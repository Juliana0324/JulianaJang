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

import kr.co.sist.vo.LoginVO;


public class LoginDAO {
	
private static LoginDAO lDAO;
	
	private LoginDAO() {
		
	}
	public static LoginDAO getInstance() {
		if(lDAO==null) {
			lDAO=new LoginDAO();
		
		}
		return lDAO;
	}
	
	public String selectMember(LoginVO lVO) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		DBCPConnection dbcp=DBCPConnection.getInstance();
		String name="";
		
		
		try {
			conn= dbcp.getConnection();
			String selectLogin="SELECT name FROM test_member WHERE id=? AND pass=?";
			pstmt=conn.prepareStatement(selectLogin);
			pstmt.setString(1, lVO.getId());
			pstmt.setString(2, lVO.getPass());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				name=rs.getString("name");
			}
			
		}finally {
			dbClose(rs,pstmt, conn);
		}
			
		System.out.println("name ==>"+name);
		return name;
	}
	

	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
	
}
