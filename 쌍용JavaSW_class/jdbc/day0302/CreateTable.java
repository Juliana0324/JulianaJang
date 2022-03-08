package day0302;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author user
 *
 */
public class CreateTable {

	public CreateTable() throws SQLException{
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		Statement stmt =null;
		try {
			//2. Connection���
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pw="tiger";
			
			conn=DriverManager.getConnection(url,id,pw);
			
			
			//3.������ ���� ��ü���
			stmt=conn.createStatement();
			
			//4.���� ������ ��� ���
//			String createQuery="CREATE TABLE test(num number, name varchar2(30), input_date date default sysdate)";
			String createQuery="DROP TABLE test";
			boolean flag= stmt.execute(createQuery);
			//������ ������ �������̶�� ��ȸ�� ���̾�� false ����
			//���� ���� ���ж�� ���ܸ���			
//			if(flag) {
			System.out.println(flag);
			System.out.println("���̺� ���� ����"+stmt.getQueryTimeout());
//			}
		}finally {
			//5. �������
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}
	}
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException se) {
			System.err.println("���̺� ���� ����");
			se.printStackTrace();
		}
	}

}
