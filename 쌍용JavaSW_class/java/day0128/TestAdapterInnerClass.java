package day0128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestAdapterInnerClass extends JFrame {
	public TestAdapterInnerClass() {
		super("����� �̳�Ŭ����");
		
		
		//�̳�Ŭ���� ����üȭ
		TestAdapterInnerClass.InnerEvnt ie = this.new InnerEvnt();
		
		//�̺�Ʈ ���
		addWindowListener(ie);
		
		setSize(400, 300);
		setVisible(true);
		
	}
	
	//�̳� Ŭ���� ����
	public class InnerEvnt extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("Inner class���� ������ ������ ���� �̺�Ʈ");
			dispose();
		}
		
	}
	
	
	public static void main(String[] args) {
		new TestAdapterInnerClass();
	}

}
