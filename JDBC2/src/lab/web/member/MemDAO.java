package lab.web.member;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.*;

public class MemDAO {
	static{
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("드라이버 로드 성공");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	private Connection getConnection() {
		DataSource ds =null;
		Connection con=null;
		try {
			Context ctx= new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/Oracle");
			con=ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	private void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e){
			}
		}
	}
	
	public void insertMember(MemberVO mem) {
		Connection con = null;
		try {
			con=getConnection();
			String sql="insert into member values(?,?,?,?,?)";
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setString (1,mem.getUserId());
			stmt.setString(2, mem.getName());
			stmt.setString(3, mem.getPassword());
			stmt.setString(4, mem.getEmail());
			stmt.setString(5, mem.getAddress());
			stmt.executeUpdate();
		}catch(SQLException e){
			if(e.getMessage().contains("PK")) {
				throw new RuntimeException("아이디가 중복됩니다.");
			}else {
				e.printStackTrace();
				throw new RuntimeException("MemberDAO - insertMember");			
			}
	}finally {
		closeConnection(con);
	}
		}
	public String getPassword(String userId) {
		Connection con= null;
		String pw=null;
		try {
			con=getConnection();
			String sql="select password from member where userid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				pw =rs.getString(1);
			}
		}catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("MemDAO - getPassword");
			}finally {
				closeConnection(con);
			}
		return pw;
		
		}
		
	
	
	
	public List<MemberVO> selectMember(String userId){
		Connection con=null;
		List<MemberVO> list=new ArrayList<>();
		try {
			con=getConnection();
			String sql="";
			PreparedStatement stmt =con.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				MemberVO mem=new MemberVO();
				mem.setUserId(rs.getString("userid"));
				mem.setName(rs.getString("name"));
				mem.setPassword(rs.getString("password"));
				mem.setEmail(rs.getString("email"));
				mem.setAddress(rs.getString("address"));
					
			} 
		}catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("MemeberDAO - select");
			}finally {
				closeConnection(con);
			}
		return list;
		}
	
	
	}
