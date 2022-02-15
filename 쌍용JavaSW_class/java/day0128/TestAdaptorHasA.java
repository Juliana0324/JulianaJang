package day0128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 디자인 클래스를 받아 디자인 클래스의 이벤트를 처리하는 클래스
 * @author user
 *
 */
public class TestAdaptorHasA extends WindowAdapter {
	private TestDesign td;
	
	public TestAdaptorHasA(TestDesign td) {
		this.td = td;

	}
	
	
	@Override
	public void windowClosing(WindowEvent we) {
		System.out.println("외부클래스에서 윈도우 종료 이벤트 처리");
		//dispose(); // 상속 줄에는 이기능이 존재하지 x
		td.dispose();
	}
}
