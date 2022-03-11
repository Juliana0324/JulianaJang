package day0311;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import day0310.ResultVO;
import kr.co.sist.dao.DbConnection;

public class UseDeleteProcedure {
	
	public ResultVO useDeleteProcedure(int num) throws SQLException {
		ResultVO rVO=null;
		Connection conn= null;
		CallableStatement cstmt =null;
		DbConnection dc = DbConnection.getInstance();
		
		try {
			conn=dc.getConn();
			cstmt=conn.prepareCall("{call delete_test_proc(?,?,?)}");
			cstmt.setInt(1, num);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			
			cstmt.execute();
			
			//6. outParameter에 설정된 값얻기
			rVO=new ResultVO();
			rVO.setRowCnt(cstmt.getInt(2));
			rVO.setErrMsg(cstmt.getString(3));
		}finally {
			dc.close(null, cstmt, conn);
		}
		
		return rVO;
	}
	public static void main(String[] args) {
		UseDeleteProcedure udp= new UseDeleteProcedure();
		int num=6;
		try {
			ResultVO rVO= udp.useDeleteProcedure(num);
			System.out.println(rVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
