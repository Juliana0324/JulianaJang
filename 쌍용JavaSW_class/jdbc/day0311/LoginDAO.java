package day0311;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.sist.dao.DbConnection;

public class LoginDAO {
	public String useStatement(LoginVO lVO) throws SQLException{
		String name="";
		//1.
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs= null;
		DbConnection dc= DbConnection.getInstance();
		//2.
		try {
			conn=dc.getConn();
			stmt=conn.createStatement();
			
			StringBuilder selectLogin= new StringBuilder();
			selectLogin.append("SELECT name FROM test_login WHERE id='").append(lVO.getId())
			.append("' AND password='").append(lVO.getPasswd()).append("'");
			
			System.out.println(selectLogin);
			rs= stmt.executeQuery(selectLogin.toString());
			
			if(rs.next()) {
				name=rs.getString("name");
			}
		}finally {
			dc.close(rs, stmt, conn);
		}
		//3.
		return name;
	}
	
	public String blockInjection(String sql) {
		if(sql!= null && !"".equals(sql)) {
			//injection에 관련된 문자열 치환한다
			sql=sql.replaceAll("select", "").replaceAll("union", "")
					.replaceAll(" ", "").replaceAll("'", "").replaceAll("--","");
		}
		return sql;
	}//sql
	
	
	public String usePreparedStatement(LoginVO lvo) throws SQLException{
		String name="";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		DbConnection dc = DbConnection.getInstance();
		
		try {
			conn= dc.getConn();
			String selectLogin ="select name from test_login where id=? and password=?";
			pstmt=conn.prepareStatement(selectLogin);
			
			
			pstmt.setString(1, lvo.getId());
			pstmt.setString(2, lvo.getPasswd());
			rs = pstmt.executeQuery();
			
			System.out.println(selectLogin);
			System.out.println(lvo);
			
			if(rs.next()) {
				name=rs.getString("name");
			}
		}finally {
			dc.close(rs, pstmt, conn);
			
		}
		
		
		return name;
	}
}
