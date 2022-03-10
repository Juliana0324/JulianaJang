package day0310;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConnection;

/**
 * 변경 프로시져
 * @author user
 *
 */
public class UseUpdateProcedure {

	public ResultVO updateProce(ProcedureVO pVO) throws SQLException{
		ResultVO rVO=null;
		Connection conn= null;
		CallableStatement cstmt = null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
			conn=dc.getConn();
			cstmt=conn.prepareCall("{call update_test_proc(?,?,?,?,?)}");
			
			cstmt.setInt(1, pVO.getNum());
			cstmt.setInt(2, pVO.getAge());
			cstmt.setString(3, pVO.getEmail());
			
			//out paramether
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
			cstmt.execute();
			
			rVO=new ResultVO();
			rVO.setRowCnt(cstmt.getInt(4));
			rVO.setErrMsg(cstmt.getString(5));
			
			
		}finally {
			dc.close(null, cstmt, conn);
		}
		
		return rVO;
	}
	
	public static void main(String[] args) {
		UseUpdateProcedure uip=new UseUpdateProcedure();
		
		ProcedureVO pVO = new ProcedureVO();
		pVO.setNum(6);
		pVO.setAge(26);
		pVO.setEmail("cng@cng.com");
		
		try {
			ResultVO rVO= uip.updateProce(pVO);
			System.out.println(rVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
