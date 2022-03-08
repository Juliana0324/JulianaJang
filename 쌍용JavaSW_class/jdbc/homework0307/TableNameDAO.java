package homework0307;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.prepared.dao.TableDAO;

public class TableNameDAO {
	private static TableNameDAO tdao;
	TableNameDAO() {
		
	}
	public static TableNameDAO getInstance() {
		if(tdao==null) {
			tdao=new TableNameDAO();
		}
		return tdao;
	}
	
	public List<TableVO> selectAllTab(String table) throws SQLException{
		List<TableVO> list = new ArrayList<TableVO>();
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
			conn=dc.getConn();
			StringBuilder selectAllTab= new StringBuilder();
			
			selectAllTab.append("SELECT tname, tabtype, clusterid FROM ").append(table);
			pstmt=conn.prepareStatement(selectAllTab.toString());
			
			rs= pstmt.executeQuery();
			
			TableVO tvo =new TableVO();
			while(rs.next()) {
				tvo=new TableVO(rs.getString("tname"), rs.getString("tabtype"), rs.getString("clusterid"));
				list.add(tvo);
			}
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<TableVO> selectUTC(String table) throws SQLException{
		List<TableVO> list = new ArrayList<TableVO>();
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
			conn=dc.getConn();
			StringBuilder selectUtc= new StringBuilder();
			
			selectUtc.append("SELECT table_name, column_name, data_length FROM ").append(table);
			pstmt=conn.prepareStatement(selectUtc.toString());
			
			rs= pstmt.executeQuery();
			
			TableVO tvo =new TableVO();
			while(rs.next()) {
				tvo=new TableVO(rs.getString("table_name"), rs.getString("column_name"), rs.getInt("data_length"));
				list.add(tvo);
			}
		}finally {
			dc.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		try {
			System.out.println(new TableNameDAO().selectUTC("user_tab_cols"));
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
}
