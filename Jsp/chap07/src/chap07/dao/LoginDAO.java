package chap07.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import chap07.dto.Login;
public class LoginDAO {
	//DAO: data access object
	//	- DB�� ���̺� �����ϴ� ��ü���� DAO��� ����
	// 	- DAO�� ���� ���̺�(Ȥ�� ��)�� �� Ŭ������ �����Ѵ�
	// -�ش� ���̺� ���� ���ϴ� ������ SELECT/INSERT/DELETE/UPDATE�� �����ϴ� �޼��带 �̰��� ����

	public static Login read(Connection conn, String user_id){
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM my_login WHERE user_id=?");
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return new Login(rs);}
			} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!= null) pstmt.close();
			}
			catch(SQLException e) {}
		}
		return null;
	}
	}
