package day0128;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestDesign extends JFrame {

	
	public TestDesign() {
		super("�ܺ�Ŭ�������� �̺�Ʈ ó��");
		
		TestAdaptorHasA taha = new TestAdaptorHasA(this);
		//System.out.println(this); => this: TestDesign
		//������ Ŭ�������� �߻��� �̺�Ʈ�� has a������ Ŭ�������� ó���ϵ��� ���
		addWindowListener(taha);
		
		setSize(500,500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TestDesign();
	}

}
