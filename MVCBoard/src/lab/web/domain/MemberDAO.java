package lab.web.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
	
	public void insertArticle(BoardVO board) {
		Connection con = null;
		String sql1="select nvl(max(bbsno),0) from board";
		int bbsno = 0;
		String sql2= "insert into board"+"(bbsno,userid,password,subject, content, "+
				"writedate, masterid, readcount, replynumber, replystep)"+
				"values(?,?,?,?,?,SYSDATE,0,0,0)";
		try {
			con=getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql1);
			ResultSet rs =pstmt.executeQuery();
			rs.next();
			bbsno=rs.getInt(1)+1;
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, bbsno);
			pstmt.setString(2, board.getUserId());
			pstmt.setString(3, board.getPassword());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, bbsno);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.insertArticle() 예외발생-콘솔확인");
		}finally {
			closeConnection(con);
		}
	}
	
	public Collection<BoardVO> selectArticleList(int page){
		Connection con=null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql="select bbsno, name, subject,writedate, readcount, rnum from ("+
				"select bbsno, name, subject, writedate, readcount, rownum as rnum from ("+
				"select bbsno, name, subject, writedate, readcount from board b "+
				"join member m on b.userid=m.userid "+
				"order by masterid desc, replynumber, replystep)) "+
				"where rnum between ? and ?";
		int start =(page-1)*10 +1;
		int end =start+9;
		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBbsno(rs.getInt("bbsno"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setWriteDate(rs.getDate("writedate"));
				board.setReadCount(rs.getInt("readcount"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.selectArticleList()예외발생 - 콘솔확인");
		}finally {
			closeConnection(con);
		}
		return list;
	}
	
	public BoardVO selectArticle(int bbsno) {
		Connection con = null;
		BoardVO board = null;
		String sql = "select bbsno, name, b.userid, subject, content, readcount, "+
				"writedate, masterid, replynumber, replaystep "
				+ "from board b join member m on b.userid=m.userid where bbsno=?";
		try {
			con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bbsno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board= new BoardVO();
				board.setBbsno(rs.getInt("bbsno"));
				board.setName(rs.getString("name"));
				board.setUserId(rs.getString("userid"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readcount"));
				board.setWriteDate(rs.getDate("writedate"));
				board.setMasterId(rs.getInt("masterid"));
				board.setReplyNumber(rs.getInt("replynumber"));
				board.setReplyStep(rs.getInt("replystep"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.selectArticleList()예외발생 - 콘솔확인");
		}finally {
			closeConnection(con);

		}
		return board;
	}
	
	public void updateReadCount(int bbsno) {
		Connection con =null;
		String sql="update board set readcount = readcount+1 where bbsno=?";
		try {
			con= getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbsno);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.updateReadCount()예외발생 - 콘솔확인");
		}finally {
			closeConnection(con);
		}
	}
	public void replyArticle(BoardVO board) {
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			String sql1="update board set replynumber=replynumber+1 where masterid=? and replynumber >?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1, board.getMasterId());
			pstmt.setInt(2, board.getReplyNumber());
			pstmt.executeUpdate();
		
		String sql2="select max(bbsno) from board";
		pstmt= con.prepareStatement(sql2);
		rs= pstmt.executeQuery();
		if(rs.next()) {
			board.setBbsno(rs.getInt(1)+1);
			}
		String sql3= "insert into board values(?,?,?,?,?,SYSDATE,?,0,?,?)";
		pstmt.getConnection().prepareStatement(sql3);
		pstmt.setInt(1, board.getBbsno());
		pstmt.setString(2, board.getUserId());
		pstmt.setString(3, board.getPassword());
		pstmt.setString(4, board.getSubject());
		pstmt.setString(5, board.getContent());
		pstmt.setInt(6, board.getMasterId());
		pstmt.setInt(7,board.getReplyNumber()+1);
		pstmt.setInt(8, board.getReplyStep()+1);
		pstmt.executeUpdate();
		con.commit();
		}catch(Exception e) {
			try {
				con.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException("BoardDAO.replyArticle()예외발생-콘솔확인");
			}finally {
				closeConnection(con);
			}
		}
	}
	public void deleteArticle(int bbsno, int replynumber) {
		String sql="";
		Connection con= null;
		try {
			con=getConnection();
			if(replynumber>0) {
				sql="delete from board where bbsno=?";
			}else {
				sql="delete from board where masterid=?";
			}
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, bbsno);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.deleteArtice() 예외발생-콘솔확인");
		}finally {
			closeConnection(con);
		}
	}
	
	public int selectTotalBbsCount() {
		Connection con= null;
		String sql="select count(bbsno) from board";
		try {
			con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int bbsCount = rs.getInt(1);
			return bbsCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.selectTotalBbsCount()예외발생-콘솔확인");
		}finally {
			closeConnection(con);
		}
	}
	public void updateArticle(BoardVO board) {
		Connection con = null;
		String sql="update board set "+
				"subject=?, content=?, writedate=SYSDATE "+
				"where bbsno=?";
		try {
			con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBbsno());
			pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
		throw new RuntimeException("BoardDAO.updateArticle()예외발생-콘솔확인");
	}finally {
		closeConnection(con);
	}
	}
	public int selectCount(String userid) {
		Connection con =null;
		String sql="select count(bbsno) from board where userid=?";
		try {
			con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.selectCount()예외발생-콘솔확인");
		}finally {
			closeConnection(con);
		}
	}

	public Collection<BoardVO> memberList(String userid, int page){
		Connection con =null;
		String sql="select rnum, bbsno, name, subject, readcount, writedate from "+
				"(select rownum rnum, bbsno, name, subject, readcount, writedate from "+
				"(select bbsno, name, subject, readcount, writedate from board b "+
				"join member m on b.userid = m.userid where b.userid=? order by bbsno desc))"+
				"where rnum between ? and ?";
		ArrayList<BoardVO> list =new ArrayList<>();
		int start =(page-1)*20 +1;
		int end = start+19;
		try {
			con=getConnection();
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBbsno(rs.getInt("bbsno"));
				board.setName(rs.getString("name"));
				board.setWriteDate(rs.getDate("writedate"));
				board.setSubject(rs.getString("subject"));
				board.setReadCount(rs.getInt("readcount"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("BoardDAO.memberList()예외발생 - 콘솔확인");
		}finally {
			closeConnection(con);

		}
		return list;
		}
	
	
	
	}