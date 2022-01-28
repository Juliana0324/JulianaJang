package day0128;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * has a 관계로 TestKeyEvtDesign 클래스의 이벤트를 처리할 클래스
 * @author user
 *
 */
public class TestKeyEvtProcess extends WindowAdapter implements KeyListener {
	
	private TestKeyEvtDesign tked;
	
	public TestKeyEvtProcess(TestKeyEvtDesign tked) {
		this.tked = tked;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		tked.dispose();
		//tked의 윈도우를 종료하겠다는 뜻
	}






	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
	//	System.out.println("keyPressed");

	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased");
		
		//눌린키의 키값 얻어오기
		tked.getJlblOutput().setText(String.valueOf(e.getKeyCode())+" / "+e.getKeyChar());
		
//		if(e.getKeyCode() == 27) {
//			tked.dispose();
//		}
		
		//콘솔에 JTextField에 입력된 모든 문자열을 출력.
		System.out.println(tked.getJtfKey().getText());
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			tked.dispose();
			break;
		}
	}

}
