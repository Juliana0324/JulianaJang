package chap09.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import chap09.dto.MyLogin;

public class LoginDAO {
	
	Connection conn;
	public LoginDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<MyLogin> readAll() {
		String sql= "SELECT * FROM my_login";

		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<MyLogin> list =new ArrayList<>();
		
		
		try{
			pstmt=conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MyLogin(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	
}
