package day0204;

/**
 * ����� ���� compile Exception
 * @author user
 *
 */
@SuppressWarnings("serial")
public class TabacoException extends Exception {
	public TabacoException() {
		//������ ���ܸ޼��� ���
		super("������ �߻�");
	}
	
	/**
	 * �����ڰ� ������ ���ܸ޼����� ���� ����Ҷ� ���
	 * @param msg
	 */
	public TabacoException(String msg) {
		super(msg);
	}
	
}
