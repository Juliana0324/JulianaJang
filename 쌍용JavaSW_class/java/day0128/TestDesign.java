package day0128;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestDesign extends JFrame {

	
	public TestDesign() {
		super("외부클래스에서 이벤트 처리");
		
		TestAdaptorHasA taha = new TestAdaptorHasA(this);
		//System.out.println(this); => this: TestDesign
		//디자인 클래스에서 발생한 이벤트를 has a관계의 클래스에서 처리하도록 등록
		addWindowListener(taha);
		
		setSize(500,500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TestDesign();
	}

}
