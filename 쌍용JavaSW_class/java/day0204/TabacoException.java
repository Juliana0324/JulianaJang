package day0204;

/**
 * 사용자 정의 compile Exception
 * @author user
 *
 */
@SuppressWarnings("serial")
public class TabacoException extends Exception {
	public TabacoException() {
		//정해진 예외메세지 출력
		super("흡연예외 발생");
	}
	
	/**
	 * 개발자가 정해진 예외메세지를 만들어서 출력할때 사용
	 * @param msg
	 */
	public TabacoException(String msg) {
		super(msg);
	}
	
}
