package day0311;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day0310.ProcedureVO;
import kr.co.sist.dao.DbConnection;
import oracle.jdbc.internal.OracleTypes;

public class UseSelectAllProcedure {
	
	public List<ProcedureVO> selectAll() throws SQLException{
		List<ProcedureVO> list = new ArrayList<ProcedureVO>();
		Connection conn = null;
		CallableStatement cstmt=null;
		
		
		DbConnection dc= DbConnection.getInstance();
		try {
			conn=dc.getConn();
			cstmt=conn.prepareCall("{call select_all_proc(?)}");
			//cstmt.registerOutParameter(1, Types.REF_CURSOR);//커서
//			또는 둘중에 되는걸로!
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);//커서 가져오기
			
			cstmt.execute();
//			ResultSet rs=cstmt.executeQuery();//부모가 존재하는 method는 out Parameter와는 
			//관련이 없기 때무ㅜㄴ에 코드상에는 문제가 없으나 사용할 수없다
			
			//중요!!!!!!!!!이렇게 사용하ㅣ
			ResultSet rs=(ResultSet)cstmt.getObject(1);
			
			ProcedureVO pVO=null;
			while(rs.next()) { //레코드가 존재한다면
				pVO=new ProcedureVO(); //칼럼값을 저장할 VO를 생성하고
				pVO.setNum(rs.getInt("num"));
				pVO.setName(rs.getString("name"));
				pVO.setEmail(rs.getString("email"));
				pVO.setAge(rs.getInt("age"));
				pVO.setInputDate(rs.getString("input_date"));
			
				list.add(pVO);
			}
			
		}finally {
			dc.close(null, cstmt, conn);
		}
		
		
		return list;
	}
	

	public void printProcedure(List<ProcedureVO> list) {
			if(list.isEmpty()) {
				System.out.println("레코드가 존재하지 않습니다.");
			}
			for(ProcedureVO pVO:list) {
				System.out.printf("%d\t %s\t %s\t %d\t %s\n",
						pVO.getNum(), pVO.getName(), pVO.getEmail(), pVO.getAge(), pVO.getInputDate());
			}
		
	}
	
	public List<ProcedureVO> selectNum(int num) throws SQLException{
		List<ProcedureVO> list = new ArrayList<ProcedureVO>();
		
		Connection conn= null;
		CallableStatement cstmt=null;
		DbConnection dc= DbConnection.getInstance();
		
		try {
			conn=dc.getConn();
			cstmt=conn.prepareCall("{call select_num_proc(?,?)}");
			cstmt.setInt(1, num);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.execute();
			
			ResultSet rs=(ResultSet)cstmt.getObject(2);
			ProcedureVO pVO= null;
			while(rs.next()) {
				pVO=new ProcedureVO();
				pVO.setNum(rs.getInt("num"));
				pVO.setName(rs.getString("name"));
				pVO.setEmail(rs.getString("email"));
				pVO.setAge(rs.getInt("age"));
				pVO.setInputDate(rs.getString("input_date"));

				list.add(pVO);
			}
			
		}finally {
			dc.close(null, cstmt, conn);
		}
		
		return list;
	}
	

	public static void main(String[] args) {
		UseSelectAllProcedure usp=new UseSelectAllProcedure();
		//모든 레코드 조회
		System.out.println("--------------------------------------모든칼럼 조회--------------------------------------");
		try {
			List<ProcedureVO> list = usp.selectAll();
			usp.printProcedure(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------------------------------------일부 칼럼조회---------------------------------------");
		//일부칼럼 조회
		try {
			List<ProcedureVO> list =usp.selectNum(6);
			usp.printProcedure( list );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
