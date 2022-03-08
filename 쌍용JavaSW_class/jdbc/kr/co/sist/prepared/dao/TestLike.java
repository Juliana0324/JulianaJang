package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.prepared.vo.ZipcodeVO;

/**
 * like %기호 사용
 * @author user
 *
 */
public class TestLike {

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		
		DbConnection dc= DbConnection.getInstance();
		try {
			//1. 
			conn=dc.getConn();
		//2.
			StringBuilder selectZipcode= new StringBuilder();
		//3. 
			selectZipcode.append("SELECT zipcode, sido,gugun,dong, bunji FROM zipcode ")
			//.append("WHERE dong like ?%");//인식불가
			.append("WHERE dong like ?||'%'");//인식불가
		//4.
			System.out.println(selectZipcode);
			pstmt=conn.prepareStatement(selectZipcode.toString());
			
			pstmt.setString(1, dong); //인식불가
		//5.
			rs=pstmt.executeQuery();
			
			ZipcodeVO zvo=null;
			while (rs.next()) {
				zvo=new ZipcodeVO();
				zvo.setZipcode(rs.getString("zipcode"));
				zvo.setSido(rs.getString("sido"));
				zvo.setGugun(rs.getString("gugun"));
				zvo.setDong(rs.getString("dong"));
				zvo.setBunji(rs.getString("bunji"));
				
				list.add(zvo);
			}
			
			

		
		//6.연결끊기
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public static void main(String[] args) {
		TestLike t1= new TestLike();
		try {
			System.out.println(t1.selectZipcode("상도동")); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
