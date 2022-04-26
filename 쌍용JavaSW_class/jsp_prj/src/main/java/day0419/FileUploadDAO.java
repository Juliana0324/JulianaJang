package day0419;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FileUploadDAO {
	
	private static FileUploadDAO fDAO;
	
	private FileUploadDAO() {
		
	}
	public static FileUploadDAO getInstance() {
		if(fDAO==null) {
			fDAO=new FileUploadDAO();
		
		}
		return fDAO;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn=null;
		//1. JNDI��밴ü ����
		Context ctx;
		try {
			ctx = new InitialContext();
			//2. DBCPã��
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/dbcp");
			conn=ds.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	/**������ DBMS Table�� ���������ʰ� ���ϸ� ����
	 * @param ufVO
	 * @throws SQLException
	 * @throws NamingException 
	 */
	public void insertFile(UploadFileVO ufVO) throws SQLException {
		
		Connection conn= null;
		PreparedStatement pstmt=null;
		try {
			
			//1. JNDI��밴ü ����
			//2. ����DBCP���� DataSource���
			//3. DataSource���� Connection ���
			conn = getConnection();
			
			//4. Ŀ�ؼ� ���
			String insertFile="insert into upload_file(num,name,original_name,file_system_name,ip_address) values(seq_file.nextval,?,?,?,?)";
			pstmt=conn.prepareStatement(insertFile);
			//5. ���ε� ������ ����
			
			pstmt.setString(1, ufVO.getName());
			pstmt.setString(2, ufVO.getOriginal_name());
			pstmt.setString(3, ufVO.getFile_system_name());
			pstmt.setString(4, ufVO.getIp_address());
			
			
			//6. ���������� ��� ���
			pstmt.executeQuery();
			
		}finally {
			//7. ���� ����
			dbClose(null, pstmt, conn);
			
		}
	}
	
	//fileList��ȸ
	public List<UploadFileVO> selectList() throws SQLException{
		List<UploadFileVO> list = new ArrayList<UploadFileVO>();
		
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//1. JNDO��� ��ü ����
			//2. DBCP���� DataSource ���
			//3. DataSource���� Connection���
			conn=getConnection();
			String selectFile= "select num ,name, file_system_name, ip_address, to_char(input_date,'yyyy-mm-dd hh24:mi') input_date from upload_file";
			
			//5.���ε� ������ �� ����
			//6. ��;���� �� ������
			pstmt=conn.prepareStatement(selectFile);
			rs=pstmt.executeQuery();
			
			UploadFileVO ufVO=null;
			while (rs.next()) {
				ufVO=new UploadFileVO(rs.getInt("num"), rs.getString("name"), "",rs.getString("file_system_name"),
						rs.getString("ip_address"), rs.getString("input_date"));
				
				list.add(ufVO);
			}
			
			
			
		}finally {
			dbClose(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
}
