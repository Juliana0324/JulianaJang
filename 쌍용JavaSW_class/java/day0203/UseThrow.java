package day0203;

import javax.security.auth.login.FailedLoginException;

/**
 * Ư����Ȳ���� ���ܸ� ������ �߻����� ó��
 * 
 * @author user
 *
 */
public class UseThrow {
	
	//���ܴ� �����ִ� �̸����� �����
	public void login(String id, String pw) throws FailedLoginException{
		if(!(id.equals("admin") && pw.equals("1234"))) {
			throw new FailedLoginException("�α��� ����!");
		}
		System.out.println(id+"�� �α��� �����ϼ̽��ϴ�.");
	}
	
	public static void main(String[] args) {
		UseThrow ut = new UseThrow();
		String id= "admin";
		String pw= "123";
		
		try {
			ut.login(id, pw);
		}catch (FailedLoginException lfe) {
			System.err.println("������ �޼���: "+lfe.getMessage());
			System.err.println("����ó�� ��ü��� �޼���: "+lfe);
			lfe.printStackTrace();
		}
		
	}

}
