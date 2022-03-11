package day0310;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import kr.co.sist.dao.DbConnection;

/**insert 쿼리를 가지고 있는 프로시져의 사용
 * @author user
 *
 */
public class UseInsertProcedure {
	
	public ResultVO useInsertProcedure(ProcedureVO pVO) throws SQLException{
		ResultVO rVO = null;
		Connection conn = null;
		CallableStatement cstmt =null;
		DbConnection dc = DbConnection.getInstance();
		
		try {
			conn=dc.getConn();
			cstmt= conn.prepareCall("{call insert_test_proc(?,?,?,?,?,?)}");
			cstmt.setInt(1, pVO.getNum());
			cstmt.setString(2, pVO.getName());
			cstmt.setString(3, pVO.getEmail());
			cstmt.setInt(4, pVO.getAge());
			
			//outPara
			cstmt.registerOutParameter(5, Types.NUMERIC);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			
			cstmt.execute();
			
			//6. out parameter에 저장된 값 얻기
			rVO=new ResultVO();
			rVO.setRowCnt(cstmt.getInt(5));
			rVO.setErrMsg(cstmt.getString(6));
			
		}finally {
			dc.close(null, cstmt, conn);
		}
		
		return rVO;
	}

	
	public static void main(String[] args) {
		UseInsertProcedure uip= new UseInsertProcedure();
		ProcedureVO pVO = new ProcedureVO();
		pVO.setNum(6);
		pVO.setName("김진영");
		pVO.setEmail("kim@test.com");
		pVO.setAge(23);
		
		try {
			ResultVO rVO=uip.useInsertProcedure(pVO);
			switch(rVO.getRowCnt()) {
				case 1 : System.out.println(pVO.getName()+ " 추가되었습니다."); break;
				default: System.out.println(rVO.getErrMsg());
				
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
