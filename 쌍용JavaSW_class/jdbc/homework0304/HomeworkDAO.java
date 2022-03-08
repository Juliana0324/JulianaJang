package homework0304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<CarVO> searchAllVO() throws SQLException{
		List<CarVO> list= new ArrayList<CarVO>();
		ResultSet rs= null;
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=getDBConnection();
			stmt= conn.createStatement();
			StringBuilder selectCarList = new StringBuilder();
			selectCarList.append("SELECT maker, model")
					.append(" FROM car_maker");
			
			rs=stmt.executeQuery(selectCarList.toString());
			CarVO selectAllVO=null;
			
			while(rs.next()) {
				selectAllVO= new CarVO();
				selectAllVO.setMaker(rs.getString("maker"));
				selectAllVO.setModel(rs.getString("model"));
				
				//레코드 하나를 가진 VO를 list에 추가
				list.add(selectAllVO);
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		return list;
	}
	
	
	public CarVO selectOneCar(String model) throws SQLException{
		CarVO selectOneVO=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=getDBConnection();
			stmt=conn.createStatement();
			StringBuilder selectOne= new StringBuilder();
			selectOne.append("SELECT model, car_year, price, cc, car_option, car_img, hiredate ")
			.append("FROM car_model WHERE model=UPPER('").append(model).append("')");
		
			rs=stmt.executeQuery(selectOne.toString());
			if(rs.next()) {
				selectOneVO=new CarVO();
				selectOneVO.setModel(rs.getString("model"));
				selectOneVO.setCar_year(rs.getInt("car_year"));
				selectOneVO.setPrice(rs.getInt("price"));
				selectOneVO.setCc(rs.getInt("cc"));
				selectOneVO.setCar_option(rs.getString("car_option"));
				selectOneVO.setCar_img(rs.getString("car_img"));
				selectOneVO.setHiredate(rs.getDate("hiredate"));
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		return selectOneVO;
	}
	
	public static void main(String[] args) {
		try {
			new HomeworkDAO().searchAllVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
