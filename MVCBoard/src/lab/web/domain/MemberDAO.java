package lab.web.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

public class MemberDAO {
	static {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("드라이버 로드 성공");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	private Connection getConnection() {
		DataSource ds =null;
		Connection con= null;
		try {
			Context ctx= new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			con=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		}
	private void closeConnection (Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {}
		}
	}
	
	public void insert(MemberVO member) {
		Connection con =null;
		try {
			con=getConnection();
			String sql ="insert into member values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString (1,member.getUserId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			if(e.getMessage().contains("PK")) {
				throw new RuntimeException("아이디가 중복됩니다.");
			}else {
				e.printStackTrace();
				throw new RuntimeException("MemberDAO.inser() 예외발생 - 콘솔확인");
				}
			}
			finally {
				closeConnection(con);
			}
		}
	
	public MemberVO selectMember(String userId) {
		Connection con= null;
		MemberVO member = new MemberVO();
		try {
			con =getConnection();
			String sql="select * from member wher userid=?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()) {
				member.setUserId(userId);
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDAO.selectMember()예외발생-콘솔확인");
		}
		finally {
		closeConnection(con);
	}
		return member;
	}
	public void updateMember(MemberVO member) {
		Connection con =null;
		try {
			con =getConnection();
			String sql="update member set email=?, address=?, name=?, password=? where userid=?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getAddress());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPassword());
			pstmt.setString (5,member.getUserId());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDAO.update()예외발생-콘솔확인");
		}finally {
			closeConnection(con);
		}
		}
	public String getPassword(String userId) {
		String pw="";
		Connection con= null;
		try {
			con=getConnection();
			String sql="select password from member where userid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				pw= rs.getString("password");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDAO.getPassword()예외발생-콘솔확인");
		}finally {
			closeConnection(con);
		}
		return pw;
	}
	
	public void deleteMember(String userid, String password) {
		Connection con=null;
		String pw="";
		try {
			con=getConnection();
			con.setAutoCommit(false);
			String sql="select password from member where userid=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			pw =rs.getString("password");
		}else {
			throw new RuntimeException("아이디가 잘못 입력되었습니다.");
		}
		if(pw.equals(password)) {
			try {
				String sql2 ="delete from board where masterid in "
						+"(select masterid from board where userid=?) and "
						+"(replynumber>0 or userid=?)";
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1, userid);
				pstmt.setString(2, userid);
				pstmt.executeQuery();
				String sql3="delete from member where userid=?";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, userid);
				pstmt.executeUpdate();
				con.commit();
			}catch(SQLException e) {
				con.rollback();
				throw new RuntimeException("삭제가 되지 않았습니다 : "+e.getMessage());
			}
		}else {
			throw new RuntimeException("비밀번호가 다릅니다");
		}
	}catch(SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("MemberDAO.deleteMember() 예외발생 - 콘솔확인");
	}finally {
		closeConnection(con);
	}
		}
		
	
	}
	