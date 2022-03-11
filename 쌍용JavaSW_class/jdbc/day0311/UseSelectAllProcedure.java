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
			//cstmt.registerOutParameter(1, Types.REF_CURSOR);//Ŀ��
//			�Ǵ� ���߿� �Ǵ°ɷ�!
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);//Ŀ�� ��������
			
			cstmt.execute();
//			ResultSet rs=cstmt.executeQuery();//�θ� �����ϴ� method�� out Parameter�ʹ� 
			//������ ���� �����̤��� �ڵ�󿡴� ������ ������ ����� ������
			
			//�߿�!!!!!!!!!�̷��� ����Ϥ�
			ResultSet rs=(ResultSet)cstmt.getObject(1);
			
			ProcedureVO pVO=null;
			while(rs.next()) { //���ڵ尡 �����Ѵٸ�
				pVO=new ProcedureVO(); //Į������ ������ VO�� �����ϰ�
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
				System.out.println("���ڵ尡 �������� �ʽ��ϴ�.");
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
		//��� ���ڵ� ��ȸ
		System.out.println("--------------------------------------���Į�� ��ȸ--------------------------------------");
		try {
			List<ProcedureVO> list = usp.selectAll();
			usp.printProcedure(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------------------------------------�Ϻ� Į����ȸ---------------------------------------");
		//�Ϻ�Į�� ��ȸ
		try {
			List<ProcedureVO> list =usp.selectNum(6);
			usp.printProcedure( list );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
