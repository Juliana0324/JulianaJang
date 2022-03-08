package day0302;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc connection�� �����Ѵ�
 * @author user
 *
 */
public class GetConnection {
	
	public GetConnection() throws SQLException{
		//1. ����̹� �ε�(e:/dev/driver/ojdbc8.jar)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) { //compile exception(Checked exception)
			System.out.println("����̹� ���� ����");
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="tiger";
		System.out.println("����̹� ���Ἲ��");
		
		Connection con=null;
		Statement stmt=null;
		PreparedStatement psmt=null;
		try {
			con= DriverManager.getConnection(url,id,pw);
			System.out.println("db���� ����"+con);

			//3.������ ������ü ���
			stmt=con.createStatement();
			
			String dname="���ߺ�";
			//4.������ ���� �� ���
			String insertQuery="insert into cp_dept(deptno, dname, loc) values(99, '"+dname+"','����')";
			int cnt= stmt.executeUpdate(insertQuery);
			System.out.println(insertQuery+"�� "+cnt+"���� �߰��Ǿ����ϴ�");
			//psmt=con.prepareStatement(insertQuery);
			
		}
		finally {
			//5.�������
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			new GetConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
