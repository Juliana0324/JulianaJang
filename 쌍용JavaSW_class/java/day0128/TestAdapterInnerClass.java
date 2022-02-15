package day0128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestAdapterInnerClass extends JFrame {
	public TestAdapterInnerClass() {
		super("어댑터 이너클래스");
		
		
		//이너클래스 ㅂ객체화
		TestAdapterInnerClass.InnerEvnt ie = this.new InnerEvnt();
		
		//이벤트 등록
		addWindowListener(ie);
		
		setSize(400, 300);
		setVisible(true);
		
	}
	
	//이너 클래스 시작
	public class InnerEvnt extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("Inner class에서 종료한 윈도우 종료 이벤트");
			dispose();
		}
		
	}
	
	
	public static void main(String[] args) {
		new TestAdapterInnerClass();
	}

}
