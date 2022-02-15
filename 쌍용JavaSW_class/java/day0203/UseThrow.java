package day0203;

import javax.security.auth.login.FailedLoginException;

/**
 * 특정상황에서 예외를 강제로 발생시켜 처리
 * 
 * @author user
 *
 */
public class UseThrow {
	
	//예외는 관련있는 이름으로 만들기
	public void login(String id, String pw) throws FailedLoginException{
		if(!(id.equals("admin") && pw.equals("1234"))) {
			throw new FailedLoginException("로그인 실패!");
		}
		System.out.println(id+"님 로그인 성공하셨습니다.");
	}
	
	public static void main(String[] args) {
		UseThrow ut = new UseThrow();
		String id= "admin";
		String pw= "123";
		
		try {
			ut.login(id, pw);
		}catch (FailedLoginException lfe) {
			System.err.println("간단한 메세지: "+lfe.getMessage());
			System.err.println("예외처리 객체명와 메세지: "+lfe);
			lfe.printStackTrace();
		}
		
	}

}
