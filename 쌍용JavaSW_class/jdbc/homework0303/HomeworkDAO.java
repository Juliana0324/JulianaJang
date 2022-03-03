package homework0303;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class HomeworkDAO {
	
	private Connection getDBConnection() throws SQLException{
		Connection conn=null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="tiger";
		conn= DriverManager.getConnection(url, id,pw);
		
		return conn;
	}
	public void insertName(String name) throws SQLException{
		
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=getDBConnection();
			stmt= conn.createStatement();
					
			StringBuilder insertName=new StringBuilder();
			insertName.append("INSERT INTO names(name) VALUES('").append(name).append("')");
			
			stmt.executeUpdate(insertName.toString());
			JOptionPane.showMessageDialog(null, name+"님이 추가되었습니다.");
		}finally {
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		
	}
}
