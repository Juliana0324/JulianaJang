package day0314;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

/**
 * @author user
 *
 */
public class ZipcodeDAO {
	private static ZipcodeDAO zDAO;
	private ZipcodeDAO() {
		
	}
	public static ZipcodeDAO getInstance() {
		if(zDAO==null) {
			zDAO=new ZipcodeDAO();
		}
		
		return zDAO;
	}
	
	//sqlInjection 처리
	public String blockInjection(String sql) {
		if(sql!= null && !"".equals(sql)) {
			//injection에 관련된 문자열 치환한다
			sql=sql.replaceAll("select", "").replaceAll("union", "")
					.replaceAll(" ", "").replaceAll("'", "").replaceAll("--","");
		}
		return sql;
	}//sql
	
	
	
	
	/**
	 * sqlInjection에 대한 코드
		where dong like '
		' union select tname,'0','0','0','0' from tab--
		
		' union select column_name,'0','0','0','0' from user_tab_cols where table_name='TEST_LOGIN'--
		
		' union select id, password, name, to_char(input_date, 'yyyy-mm-dd'),'0' from TEST_LOGIN--
	 */
	public List<ZipcodeVO> selectStatement(String dong)throws SQLException{
		List<ZipcodeVO> list= new ArrayList<ZipcodeVO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
			conn=dc.getConn();
			stmt=conn.createStatement();
			StringBuilder selectDong = new StringBuilder();
			selectDong.append("SELECT zipcode, sido, gugun, dong, nvl(bunji,' ') bunji ")
			.append("FROM zipcode ")
			.append("WHERE dong like '").append(blockInjection(dong)).append("%'");
			
			rs=stmt.executeQuery(selectDong.toString());			
			ZipcodeVO zVO=null;
			while(rs.next()) {
				zVO=new ZipcodeVO();
				zVO.setZipcode(rs.getString("zipcode"));
				zVO.setSido(rs.getString("sido"));
				zVO.setGugun(rs.getString("gugun"));
				zVO.setDong(rs.getString("dong"));
				zVO.setBunji(rs.getString("bunji"));
				
				list.add(zVO);
			}
			
		}finally {
			dc.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	public List<ZipcodeVO> selectPreparedStatement(String dong)throws SQLException{
		List<ZipcodeVO> list= new ArrayList<ZipcodeVO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
			conn= dc.getConn();
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append("SELECT zipcode,sido,gugun,dong,nvl(bunji,' ') bunji FROM zipcode ")
			.append("WHERE dong like ?||'%'");
			
			pstmt=conn.prepareStatement(selectZipcode.toString());
			pstmt.setString(1, dong);
			rs=pstmt.executeQuery();
			
			ZipcodeVO zVO=null;
			while(rs.next()) {
				zVO=new ZipcodeVO();
				zVO.setZipcode(rs.getString("zipcode"));
				zVO.setSido(rs.getString("sido"));
				zVO.setGugun(rs.getString("gugun"));
				zVO.setDong(rs.getString("dong"));
				zVO.setBunji(rs.getString("bunji"));
				
				list.add(zVO);
			}
			
		}finally {
			dc.close(rs, pstmt, conn);
		}
		
		
		return list;
	}

	public static void main(String[] args) {
		ZipcodeDAO zDAO=new ZipcodeDAO();
		
		try {
			System.out.println(zDAO.selectPreparedStatement("상도동"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	