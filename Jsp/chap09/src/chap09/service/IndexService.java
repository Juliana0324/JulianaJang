package chap09.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import chap09.dao.LoginDAO;
import chap09.dto.MyLogin;
import chap09.jdbc.connectionProvider;

public class IndexService {
	
	public static List<MyLogin> getAllUser(){
		try(Connection conn = connectionProvider.getConnetion()){
			LoginDAO loginDAO=new LoginDAO(conn);
			return loginDAO.readAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
