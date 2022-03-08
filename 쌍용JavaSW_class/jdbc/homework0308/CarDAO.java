package homework0308;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

public class CarDAO {
	
	private static CarDAO cdao;
	private CarDAO() {
		
	}
	public static CarDAO getInstance(){
		if(cdao==null) {
			cdao=new CarDAO();
		}
		return cdao;
		
	}
	
	public List<CarVO> searchCar(String model) throws SQLException{
		List<CarVO> list = new ArrayList<CarVO>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
			conn=dc.getConn();
			StringBuilder selectModel = new StringBuilder();
			
			selectModel.append("SELECT cc.country, cma.maker, cmo.model, cmo.car_year, cmo.price, cmo.car_option ")
			.append("FROM car_country cc, car_maker cma, car_model cmo ")
			.append("WHERE (cma.maker=cc.maker and cmo.model=cma.model) ")
			.append("AND cma.maker=UPPER(?)");

			pstmt= conn.prepareStatement(selectModel.toString());
			pstmt.setString(1, model);
			rs = pstmt.executeQuery();
			
			CarVO cVO = null;
			while(rs.next()) {
				cVO= new CarVO();
				cVO.setCountry(rs.getString("country"));
				cVO.setMaker(rs.getString("maker"));
				cVO.setModel(rs.getString("model"));
				cVO.setCarYear(rs.getInt("car_year"));
				cVO.setPrice(rs.getInt("price"));
				cVO.setCarOption(rs.getString("car_option"));
				
				list.add(cVO);
				
			}
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		CarDAO cd= new CarDAO();
		try {
			System.out.println(cd.searchCar("Çö´ë"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
