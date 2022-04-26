package day0418;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empDAO {
	
	public List<empVO> selectAllEmp() throws SQLException{
		List<empVO> list = new ArrayList<empVO>();
		 Connection conn= null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url="jdbc:oracle:thin:@211.63.89.147:1521:orcl";
			String id="scott";
			String pw="tiger";
			
			try {
				conn= DriverManager.getConnection(url, id,pw);
				String sql= "SELECT EMPNO, ENAME, JOB, sal, HIREDATE FROM EMP";
				pstmt=conn.prepareStatement(sql);
				rs =pstmt.executeQuery();
				
				empVO eVO = null;
				while(rs.next()){
					eVO=new empVO( rs.getString("ename"),rs.getString("job"),rs.getInt("empno"),rs.getInt("sal"),rs.getDate("hiredate"));
					
					list.add(eVO);
				}
			}finally {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			
			return list;
	}
}
