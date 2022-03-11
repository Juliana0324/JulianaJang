package day0311;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;
import oracle.jdbc.internal.OracleTypes;

public class Homework0311DAO {

	public String useLogin(LoginVO lvo) throws SQLException{
		String name="";
		
		Connection conn= null;
		CallableStatement cstmt=null;
		DbConnection dc = DbConnection.getInstance();
		
		try {
			conn = dc.getConn();
			cstmt=conn.prepareCall("{call login_proc(?,?,?)}");
			cstmt.setString(1, lvo.getId());
			cstmt.setString(2, lvo.getPasswd());
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			
			cstmt.execute();
			
			ResultSet rs = (ResultSet)cstmt.getObject(3);
						
			if(rs.next()) {
				name=rs.getString("name");
			}
			
			
		}finally {
			dc.close(null, cstmt, conn);
		}
		return name;
	}

	public static void main(String[] args) {
		Homework0311DAO hDAO= new Homework0311DAO();
		
		LoginVO lVO=new LoginVO();
		lVO.setId("kim");
		lVO.setPasswd("1234");
		
		try {
			System.out.println(hDAO.useLogin(lVO));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


