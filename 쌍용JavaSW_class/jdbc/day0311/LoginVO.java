package day0311;

public class LoginVO {
	private String id, passwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", passwd=" + passwd + "]";
	}
	
	
}
