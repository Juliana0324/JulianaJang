package chap07.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	private String user_id;
	private String user_pass;
	private int user_per;
	
	public Login() {}

	public Login(ResultSet rs) throws SQLException {
		user_id=rs.getString(1);
		user_pass=rs.getString(2);
		user_per=rs.getInt(3);
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public int getUser_per() {
		return user_per;
	}
	public void setUser_per(int user_per) {
		this.user_per = user_per;
	}
	
}
