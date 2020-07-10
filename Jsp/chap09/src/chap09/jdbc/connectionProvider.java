package chap09.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionProvider {
	public static Connection getConnetion() throws SQLException{
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:mydbcp");
		}
}
