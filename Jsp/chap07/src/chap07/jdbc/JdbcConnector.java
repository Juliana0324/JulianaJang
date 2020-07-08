package chap07.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
	//static: 클래스당 단 하나만 존재하는 영역
	final static String URL="jdbc:oracle:thin:scott/TIGER@localhost:1521:XE";
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException  {
		return DriverManager.getConnection(URL);
		
	}
}
